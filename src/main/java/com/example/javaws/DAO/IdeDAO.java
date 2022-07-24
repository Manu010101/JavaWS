package com.example.javaws.DAO;

import com.example.javaws.entites.Ide;
import com.example.javaws.entites.Langage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class IdeDAO {

    private static final String PERSISTENCE_UNIT_NAME = "persistenceUnit";

    public static Ide findById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Ide ide = em.find(Ide.class, id);
        em.close();
        return ide;
    }

    public static Langage getLangageAssocieToIde(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Ide ide = em.find(Ide.class, id);
        Langage langage = ide.getLangage();
        em.close();
        return langage;
    }
    public static List<Ide> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT i FROM Ide i");

        return q.getResultList();
    }

    public static void create(Ide ide) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(ide);
        em.getTransaction().commit();
        em.close();
    }

    public static List<Integer> getIdeIds(){
        List<Integer> ideIds = new ArrayList<>();
        List<Ide> ides = IdeDAO.getAll();
        for (Ide ide : ides) {
            ideIds.add(ide.getId());
        }
        return ideIds;
    }

}
