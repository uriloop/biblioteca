package controller;

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

public class PimientosController {
    private Connection connection;
    private EntityManagerFactory entityManagerFactory;
    private List<Pimiento> pimientos ;

    private CultivoController cultivoController = new CultivoController(connection);
    private CaracteristicasController caracteristicasController = new CaracteristicasController(connection);

    public PimientosController(Connection connection) {
        this.connection = connection;
    }

    public PimientosController(Connection connection, EntityManagerFactory entityManagerFactory) {
        this.connection = connection;
        this.entityManagerFactory = entityManagerFactory;
        pimientos = new ArrayList<>();
    }
    public PimientosController() {
        super();
    }
    public List<Pimiento> readPimientosFile(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea = "";
        while((linea = br.readLine()) != null){
            List<String> camps = getCamps(linea, ":");
            pimientos.add(new Pimiento(Integer.parseInt(camps.get(0)),camps.get(1), camps.get(2),camps.get(3), camps.get(4),camps.get(5)  ));
        }

        return pimientos;
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

        /* Method to CREATE pimiento in the database */
    public void addPimiento(Pimiento pimiento) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(pimiento);
        em.getTransaction().commit();
        em.close();

    }

    /* Method to READ all Pimientos */
    public void listPimientos() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Pimiento> result = em.createQuery("from Pimiento", Pimiento.class)
                .getResultList();
        for (Pimiento pimiento : result) {
            System.out.println(pimiento.toString());
        }
        em.getTransaction().commit();
        em.close();
    }

    /* Method to UPDATE activity for an Article */
    public void updatePimiento(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Pimiento pimiento = (Pimiento) em.find(Pimiento.class, id);
        em.merge(pimiento);
        em.getTransaction().commit();
        em.close();
    }

    /* Method to DELETE an Article from the records */
    public void deletePimiento(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Pimiento pimiento = (Pimiento) em.find(Pimiento.class, id);
        em.remove(pimiento);
        em.getTransaction().commit();
        em.close();
    }


}
