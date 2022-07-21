package com.example.javaws.rest.entites;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;
@Entity
@XmlRootElement(name="Langage")
@XmlAccessorType(XmlAccessType.FIELD)
public class Langage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String caracteristiques;

    @OneToMany(mappedBy = "langage", fetch = FetchType.EAGER)
    @XmlTransient
    private List<Ide> ides;

    public Langage(){

    }

    public Langage(String nom, String caracteristiques) {
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

    public List<Ide> getIdes() {
        return ides;
    }

    public void setIdes(List<Ide> ides) {
        this.ides = ides;
    }

    @Override
    public String toString() {
        return "Langage{" +
                " nom= " + this.getNom() +
                " -- caracteristiques= " + this.getCaracteristiques() +
                " }";
    }

}
