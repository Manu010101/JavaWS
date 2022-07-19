package com.example.javaws.rest;

import com.example.javaws.rest.DAO.LangageDAO;
import com.example.javaws.rest.entites.Langage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class essai {

    public static void main(String[] args) {

//        Langage l1 = new Langage("java", "bien");
//        LangageDAO.create(l1);

        LangageDAO.destroy(1);
    }
}
