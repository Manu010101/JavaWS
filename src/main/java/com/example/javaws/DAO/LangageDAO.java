package com.example.javaws.DAO;

import com.example.javaws.entites.Ide;
import com.example.javaws.entites.Langage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class LangageDAO {

    private static final String PERSISTENCE_UNIT_NAME = "persistenceUnit";

    public static Langage findById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Langage langage = em.find(Langage.class, id);
        em.close();
        return langage;
    }

    public static List<Ide> getIdesAssociesToLangage(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Langage langage = em.find(Langage.class, id);
        List<Ide> ides = langage.getIdes();
        em.close();
        return ides;
    }

    public static List<Langage> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT l FROM Langage l");

        return q.getResultList();
    }

    public static void destroy(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.createNativeQuery("DELETE FROM ide WHERE ide.langage_id = ?")
                .setParameter(1, id)
                .executeUpdate();

        em.createQuery("DELETE FROM Langage AS l WHERE l.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public static void create(Langage langage) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(langage);
        em.getTransaction().commit();
        em.close();
    }

    public static void update(int id, String nom, String caracteristiques) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Langage langage = em.find(Langage.class, id);


        langage.setNom(nom);
        langage.setCaracteristiques(caracteristiques);

        em.getTransaction().commit();
        em.close();
    }

    public static List<Integer> getLangagesIds(){
        List<Integer> langageIds = new ArrayList<>();
        List<Langage> langages = LangageDAO.getAll();
        for (Langage langage : langages) {
            langageIds.add(langage.getId());
        }
        return langageIds;
    }


}
