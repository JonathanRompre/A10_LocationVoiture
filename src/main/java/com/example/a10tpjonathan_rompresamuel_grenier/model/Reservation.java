package com.example.a10tpjonathan_rompresamuel_grenier.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer user_id;
    @Column(name = "automobile_id")
    private Integer automobileId;
    private Date date_reservation;
    private Date date_sortie;

    @ManyToOne
    @JoinColumn(name = "client_id_FK")
    private Client client;

    public Reservation() {
    }

    public Reservation(Integer user_id, Integer automobileId, Date date_reservation, Date date_sortie) {
        this.user_id = user_id;
        this.automobileId = automobileId;
        this.date_reservation = date_reservation;
        this.date_sortie = date_sortie;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAutomobileId() {
        return automobileId;
    }

    public void setAutomobileId(Integer automobile_id) {
        this.automobileId = automobile_id;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", automobile_id=" + automobileId +
                ", date_reservation=" + date_reservation +
                ", date_sortie=" + date_sortie +
                '}';
    }
}
