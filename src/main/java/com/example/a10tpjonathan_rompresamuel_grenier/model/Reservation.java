package com.example.a10tpjonathan_rompresamuel_grenier.model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "automobile_id")
    private Integer automobileId;
    @Column(name = "date_reservation")
    private Date dateReservation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_sortie")
    private Date dateSortie;

    @ManyToOne
    @JoinColumn(name = "client_id_FK")
    private Client client;

    public Reservation() {
    }

    public Reservation(Integer automobileId, Date dateReservation, Date dateSortie) {
        this.automobileId = automobileId;
        this.dateReservation = dateReservation;
        this.dateSortie = dateSortie;

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

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date date_reservation) {
        this.dateReservation = date_reservation;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date date_sortie) {
        this.dateSortie = date_sortie;
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
                ", automobile_id=" + automobileId +
                ", date_reservation=" + dateReservation +
                ", date_sortie=" + dateSortie +
                '}';
    }
}
