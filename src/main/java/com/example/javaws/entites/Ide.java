package com.example.javaws.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Ide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    private String caracteristiques;

    @ManyToOne()
    @JsonIgnore
    private Langage langage;

    public Ide() {

    }

    public Ide(String nom, String caracteristiques) {
        this.nom = nom;
        this.caracteristiques = caracteristiques;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(String caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public Langage getLangage() {
        return langage;
    }

    public void setLangage(Langage langage) {
        this.langage = langage;
    }
}
