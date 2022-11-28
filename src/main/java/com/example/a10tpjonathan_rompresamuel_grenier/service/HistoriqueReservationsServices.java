package com.example.a10tpjonathan_rompresamuel_grenier.service;

import com.example.a10tpjonathan_rompresamuel_grenier.model.HistoriqueReservation;
import com.example.a10tpjonathan_rompresamuel_grenier.model.Reservation;
import com.example.a10tpjonathan_rompresamuel_grenier.repository.HistoriqueReservationsRepository;
import com.example.a10tpjonathan_rompresamuel_grenier.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class HistoriqueReservationsServices {

    @Autowired
    private HistoriqueReservationsRepository historiqueReservationsRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    public void ajouterHistoriqueReservation(Reservation reservation){
        HistoriqueReservation historiqueReservation = new HistoriqueReservation();
        historiqueReservation.setAutomobile_id(reservation.getAutomobileId());
        historiqueReservation.setClient(reservation.getClient());
        historiqueReservation.setDate_sortie(reservation.getDate_sortie());
        historiqueReservation.setDate_reservation(reservation.getDate_reservation());
        historiqueReservation.setDate_retour(new Date());
        reservationRepository.delete(reservation);
        historiqueReservationsRepository.save(historiqueReservation);
    }
}
