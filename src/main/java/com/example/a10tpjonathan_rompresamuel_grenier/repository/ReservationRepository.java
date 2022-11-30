package com.example.a10tpjonathan_rompresamuel_grenier.repository;

import com.example.a10tpjonathan_rompresamuel_grenier.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findReservationByAutomobileId(Integer automobile_id);

}
