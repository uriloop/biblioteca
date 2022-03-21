package controller;

import model.Caracteristicas;
import model.Cultivo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class CultivoController implements Serializable {

    private Connection connection;
    private EntityManagerFactory entityManagerFactory;

    public CultivoController() {
        super();
    }

    public CultivoController(Connection connection) {
        this.connection=connection;
    }

    public CultivoController(Connection connection, EntityManagerFactory entityManagerFactory) {
        this.connection = connection;
        this.entityManagerFactory = entityManagerFactory;
    }

    public void printCultivo(Cultivo cultivo) {
        System.out.println(cultivo.toString());
    }

    /* Method to CREATE a Magazine  in the database */
    public void addCultivo(Cultivo cultivo) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(cultivo);

        em.getTransaction().commit();
        em.close();
    }

    /* Method to READ all Magazines */
    public void listCultivo() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Cultivo> result = em.createQuery("from Cultivo", Cultivo.class)
                .getResultList();



        for (Cultivo cultivo : result) {
            System.out.println(cultivo.toString());
        }
        em.getTransaction().commit();
        em.close();
    }

    /* Method to UPDATE activity for an Magazine */
    public void updateCultivo(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Cultivo cultivo = (Cultivo) em.find(Cultivo.class, id);
        em.merge(cultivo);
        em.getTransaction().commit();
        em.close();
    }

    /* Method to DELETE an Magazine from the records */
    public void deleteCultivo(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Cultivo cultivo = (Cultivo) em.find(Cultivo.class, id);
        em.remove(cultivo);
        em.getTransaction().commit();
        em.close();
    }


        private List<Cultivo> cultivos = new ArrayList<>();

    public List<Cultivo> readCultivoFile(String s) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader(s));
            String linea = "";
            while((linea = br.readLine()) != null){
                List<String> camps = getCamps(linea, ",");
                cultivos.add(new Cultivo(Integer.parseInt(camps.get(0)),Integer.parseInt(camps.get(1)), Integer.parseInt(camps.get(2)),Integer.parseInt(camps.get(3)),Integer.parseInt(camps.get(4)), Integer.parseInt(camps.get(5)),Integer.parseInt(camps.get(6)),Integer.parseInt(camps.get(7)),(camps.get(8))));
            }

            return cultivos;
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
}
