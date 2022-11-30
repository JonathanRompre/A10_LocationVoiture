package com.example.a10tpjonathan_rompresamuel_grenier.service;

import com.example.a10tpjonathan_rompresamuel_grenier.model.Reservation;
import com.example.a10tpjonathan_rompresamuel_grenier.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class ReservationsServices {

    @Autowired
    private ReservationRepository reservationRepository;

    public void ajouterReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public Reservation findReservationByAutoId(Integer automobile_id) {
        return reservationRepository.findReservationByAutomobileId(automobile_id).get(0);
    }
}
