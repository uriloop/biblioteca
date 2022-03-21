import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.CaracteristicasController;
import controller.CultivoController;
import controller.PimientosController;
import database.ConnectionFactory;
import model.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import view.Menu;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {

    static SessionFactory sessionFactoryObj;
/*
  private static SessionFactory buildSessionFactory() {
    // Creating Configuration Instance & Passing Hibernate Configuration File
    Configuration configObj = new Configuration();
    configObj.configure("hibernate.cfg.xml");

    // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
    ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

    // Creating Hibernate SessionFactory Instance
    sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
    return sessionFactoryObj;
  } */

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();

        } catch (HibernateException he) {
            System.out.println("Session Factory creation failure");
            throw he;
        }
    }

    public static EntityManagerFactory createEntityManagerFactory() {
        EntityManagerFactory emf;
        try {
            emf = Persistence.createEntityManagerFactory("biblioteca");
        } catch (Throwable ex) {
            System.err.println("Failed to create EntityManagerFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        return emf;
    }

    /** Ejecuta el programa i sus funciones
     * @param args
     */
    public static void main(String[] args) {
        List<Pimiento> pimientos = new ArrayList();
        List<Caracteristicas> caracteristicas = new ArrayList();
        List<Cultivo> cultivo = new ArrayList();

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection c = connectionFactory.connect();

//    SessionFactory sessionFactory = buildSessionFactory();
        EntityManagerFactory entityManagerFactory = createEntityManagerFactory();
        //sessionObj = buildSessionFactory().openSession();


        PimientosController pimientosController = new PimientosController(c, entityManagerFactory);
        CaracteristicasController caracteristicasController = new CaracteristicasController(c, entityManagerFactory);
        CultivoController cultivoController = new CultivoController(c, entityManagerFactory);

        int opcio;
        Menu menu;
        int id;
        String nombre;
        while (true) {
            menu = new Menu();
            opcio = menu.mainMenu();
            switch (opcio) {

                case 1:
                    System.out.println("1!!");
                    try {
                        pimientos = pimientosController.readPimientosFile("src/main/resources/pimientos.txt");
                        pimientos.forEach(pimientosController::addPimiento);

                    } catch (NumberFormatException | IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        caracteristicas = caracteristicasController.readCaracFile("src/main/resources/caracteristicas.txt");
                        caracteristicas.forEach(caracteristicasController::addCaracteristicas);
                    } catch (NumberFormatException | IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        cultivo = cultivoController.readCultivoFile("src/main/resources/cultivo.txt");
                        cultivo.forEach(cultivoController::addCultivo);

                    } catch (NumberFormatException | IOException e) {
                        e.printStackTrace();
                    }
                    break;


                case 2:
                    System.out.println("2!!");

                    pimientosController.listPimientos();
                    caracteristicasController.listCaracterisicas();
                    cultivoController.listCultivo();

                    break;
                case 3:
                    System.out.println("dime la id:");
                    id = new Scanner(System.in).nextInt();
                    pimientosController.deletePimiento(id);
                    caracteristicasController.deleteCaracteristicas(id);
                    cultivoController.deleteCultivo(id);

                    break;
                case 4:
                    System.out.println("dime la id:");
                    id = new Scanner(System.in).nextInt();
                    pimientosController.printPimiento(id);
                    caracteristicasController.printCarac(id);
                    cultivoController.printCult(id);

                    break;
                case 5:

                    for (Pimiento pimiento :
                            pimientos) {
                        pimientosController.deletePimiento(pimiento.getId());
                        caracteristicasController.deleteCaracteristicas(pimiento.getId());
                        pimientosController.deletePimiento(pimiento.getId());

                    }


                    break;

                case 6:
                    System.out.println(" escoje la id a modificar");
                    id = new Scanner(System.in).nextInt();
               nombre = new Scanner(System.in).nextLine();
                    pimientosController.modificaNombre(nombre, id);


                    break;
                case 7:
                    System.out.println(" escribe el texto a buscar (nombre)");
                    nombre = new Scanner(System.in).nextLine();
                    List<Pimiento> ids= pimientosController.buscarPorNombre(nombre);
                    for (Pimiento p :
                            ids) {
                        pimientosController.printPimiento(p.getId());
                        caracteristicasController.printCarac(p.getId());
                        cultivoController.printCult(p.getId());
                    }
                    break;

                default:
                    System.out.println("Adeu!!");
                    System.exit(1);
                    break;

            }
        }


    }
}


/*


    static User userObj;
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");

        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }

    public static void main(String[] args) {
        System.out.println(".......Hibernate Maven Example.......\n");
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            for(int i = 101; i <= 105; i++) {
                userObj = new User();
                userObj.setUserid(i);
                userObj.setUsername("Editor " + i);
                userObj.setCreatedBy("Administrator");
                userObj.setCreatedDate(new Date());

                sessionObj.save(userObj);
            }
            System.out.println("\n.......Records Saved Successfully To The Database.......\n");

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }


*/
