package com.example.a10tpjonathan_rompresamuel_grenier.model;

import java.util.List;

public class Filtres {

    List<String> marque;
    List<String> motopropulsion;
    List<String> transmission;
    String selectionMarque = "";
    String selectionMotopropulsion = "";
    String selectionTransmission = "";

    Integer selectionPrixMax = null;
    public Filtres() {
    }

    public List<String> getMarque() {
        return marque;
    }

    public void setMarque(List<String> marque) {
        this.marque = marque;
    }

    public List<String> getMotopropulsion() {
        return motopropulsion;
    }

    public void setMotopropulsion(List<String> motopropulsion) {
        this.motopropulsion = motopropulsion;
    }

    public List<String> getTransmission() {
        return transmission;
    }

    public void setTransmission(List<String> transmission) {
        this.transmission = transmission;
    }

    public String getSelectionMarque() {
        return selectionMarque;
    }

    public void setSelectionMarque(String selectionMarque) {
        this.selectionMarque = selectionMarque;
    }

    public String getSelectionMotopropulsion() {
        return selectionMotopropulsion;
    }

    public void setSelectionMotopropulsion(String selectionMotopropulsion) {
        this.selectionMotopropulsion = selectionMotopropulsion;
    }

    public String getSelectionTransmission() {
        return selectionTransmission;
    }

    public void setSelectionTransmission(String selectionTransmission) {
        this.selectionTransmission = selectionTransmission;
    }

    public Integer getSelectionPrixMax() {
        return selectionPrixMax;
    }

    public void setSelectionPrixMax(Integer selectionPrixMin) {
        this.selectionPrixMax = selectionPrixMin;
    }

    public boolean isFilterUsed(){
        return !this.getSelectionMarque().isBlank()
                || !this.getSelectionMotopropulsion().isBlank()
                || !this.getSelectionTransmission().isBlank()
                || (this.getSelectionPrixMax() != null);
    }

    @Override
    public String toString() {
        return "Filtres{" +
                "marque=" + marque +
                ", motopropulsion=" + motopropulsion +
                ", transmission=" + transmission +
                ", selectionMarque='" + selectionMarque + '\'' +
                ", selectionMotopropulsion='" + selectionMotopropulsion + '\'' +
                ", selectionTransmission='" + selectionTransmission + '\'' +
                '}';
    }
}
