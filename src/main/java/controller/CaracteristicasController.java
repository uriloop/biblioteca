package controller;

import model.Caracteristicas;
import model.Pimiento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CaracteristicasController {

    private Connection connection;
    private EntityManagerFactory entityManagerFactory;

    public CaracteristicasController() {
        super();
    }

    public CaracteristicasController(Connection connection) {
        this.connection=connection;
    }

    public CaracteristicasController(Connection connection, EntityManagerFactory entityManagerFactory) {
        this.connection = connection;
        this.entityManagerFactory = entityManagerFactory;
    }



    public void printCaracteristicas(Caracteristicas carcateristicas) {
        System.out.println(carcateristicas.toString());
    }

    /* Method to CREATE a Magazine  in the database */
    public void addCaracteristicas(Caracteristicas caracteristicas) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(caracteristicas);

        em.getTransaction().commit();
        em.close();
    }

    /* Method to READ all Magazines */
    public void listCaracterisicas() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Caracteristicas> result = em.createQuery("from Caracteristicas", Caracteristicas.class)
                .getResultList();

        for (Caracteristicas caracteristicas : result) {
            System.out.println(caracteristicas.toString());
        }
        em.getTransaction().commit();
        em.close();
    }

    /* Method to UPDATE activity for an Magazine */
    public void updateCaracteristica(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Caracteristicas caracteristicas = (Caracteristicas) em.find(Caracteristicas.class, id);
        em.merge(caracteristicas);
        em.getTransaction().commit();
        em.close();
    }

    /* Method to DELETE an Magazine from the records */
    public void deleteCaracteristicas(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Caracteristicas caracteristicas = (Caracteristicas) em.find(Caracteristicas.class, id);
        try{
            em.remove(caracteristicas);

        }catch (Exception e){

        }
        em.getTransaction().commit();
        em.close();
    }
    private List<Caracteristicas> caracteristicas = new ArrayList<>() ;

    public List<Caracteristicas> readCaracFile(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea = "";
        while((linea = br.readLine()) != null){
            List<String> camps = getCamps(linea, ",");
            caracteristicas.add(new Caracteristicas(Integer.parseInt(camps.get(0)),Integer.parseInt(camps.get(1)), Integer.parseInt(camps.get(2)),Integer.parseInt(camps.get(3)),Integer.parseInt(camps.get(4)), Integer.parseInt(camps.get(5)),Integer.parseInt(camps.get(6)),Integer.parseInt(camps.get(7)),Integer.parseInt(camps.get(8)),(camps.get(9))));
        }

        return caracteristicas;
    }



    private static List<String> getCamps(String string, String regex) {

        List<String> listTokens = new ArrayList<String>();

        try {

            StringTokenizer st = new StringTokenizer(string, regex);

            while( st.hasMoreTokens() ) {

                //add token to the list
                listTokens.add( st.nextToken() );
            }

        }catch(Exception e) {
            e.printStackTrace();
        }

        return listTokens;
    }

    public void printCarac(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Caracteristicas> result = em.createQuery("from Caracteristicas where id="+id, Caracteristicas.class)
                .getResultList();
        for (Caracteristicas caracteristicas : result) {
            System.out.println(caracteristicas.toString());
        }
        em.getTransaction().commit();
        em.close();
    }
}
