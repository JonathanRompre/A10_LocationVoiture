package com.example.a10tpjonathan_rompresamuel_grenier.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HistoriqueReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer automobile_id;
    private Date date_reservation;
    private Date date_sortie;
    private Date date_retour;

    @ManyToOne
    @JoinColumn(name = "client_id_FK")
    private Client client;

    public HistoriqueReservation() {
    }

    public HistoriqueReservation(Integer automobile_id, Date date_reservation, Date date_sortie, Date date_retour, Client client) {
        this.automobile_id = automobile_id;
        this.date_reservation = date_reservation;
        this.date_sortie = date_sortie;
        this.date_retour = date_retour;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAutomobile_id() {
        return automobile_id;
    }

    public void setAutomobile_id(Integer automobile_id) {
        this.automobile_id = automobile_id;
    }

    public Date getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

    public Date getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(Date date_sortie) {
        this.date_sortie = date_sortie;
    }

    public Date getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "HistoriqueReservation{" +
                "id=" + id +
                ", automobile_id=" + automobile_id +
                ", date_reservation=" + date_reservation +
                ", date_sortie=" + date_sortie +
                ", date_retour=" + date_retour +
                ", client=" + client +
                '}';
    }
}
