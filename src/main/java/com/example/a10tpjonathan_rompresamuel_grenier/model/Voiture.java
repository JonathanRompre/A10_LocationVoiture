package com.example.a10tpjonathan_rompresamuel_grenier.model;

import javax.persistence.*;

@Entity
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer annee;
    private String model;
    private String motopropulsion;
    private String transmission;
    private String licence;
    private double prix;

    @ManyToOne
    @JoinColumn(name = "client_id_FK")
    private Client client;

    public Voiture() {
    }

    public Voiture(Integer annee, String model, String motopropulsion, String transmission, String licence, double prix) {
        this.annee = annee;
        this.model = model;
        this.motopropulsion = motopropulsion;
        this.transmission = transmission;
        this.licence = licence;
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMotopropulsion() {
        return motopropulsion;
    }

    public void setMotopropulsion(String motopropulsion) {
        this.motopropulsion = motopropulsion;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", annee=" + annee + ", model='" + model + '\'' + ", motopropulsion='" + motopropulsion + '\'' + ", transmission='" + transmission + '\'' + ", licence='" + licence + '\'' + ", prix=" + prix + '}';
    }

}
