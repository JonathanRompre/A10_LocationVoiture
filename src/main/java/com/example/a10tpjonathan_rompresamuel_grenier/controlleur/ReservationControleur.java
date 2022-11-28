package com.example.a10tpjonathan_rompresamuel_grenier.controlleur;

import com.example.a10tpjonathan_rompresamuel_grenier.model.Automobile;
import com.example.a10tpjonathan_rompresamuel_grenier.model.Client;
import com.example.a10tpjonathan_rompresamuel_grenier.model.Reservation;
import com.example.a10tpjonathan_rompresamuel_grenier.service.AutomobilesServices;
import com.example.a10tpjonathan_rompresamuel_grenier.service.ClientsServices;
import com.example.a10tpjonathan_rompresamuel_grenier.service.ReservationsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/reservation")
public class ReservationControleur {

    @Autowired
    private ReservationsServices reservationsServices;
    @Autowired
    private ClientsServices clientsServices;
    @Autowired
    private AutomobilesServices automobilesServices;

    public ReservationControleur(ReservationsServices reservationsServices, ClientsServices clientsServices, AutomobilesServices automobilesServices){
        this.reservationsServices = reservationsServices;
        this.automobilesServices = automobilesServices;
        this.clientsServices = clientsServices;
    }

    @GetMapping
    public String nouvelleReservation(@RequestParam(required = false) Integer autoId, @RequestParam(required = false) Integer clientId, Model model){
        Client client = null;
        Automobile auto = null;
        if(clientId != null){
            client = clientsServices.trouverClient(clientId);
        }
        if(autoId != null){
            auto = automobilesServices.trouverAutomobile(autoId);
        }
        model.addAttribute("client",client);
        model.addAttribute("auto",auto);

        return "EnregistrementReservation";
    }

    @GetMapping("/confirm")
    public String confirmationReservation(@RequestParam Integer autoId, @RequestParam(required = false) Integer clientId, Model model){
        Reservation reservation = new Reservation();
        reservation.setClient(clientsServices.trouverClient(clientId));
        reservation.setAutomobileId(autoId);
        reservation.setDate_reservation(new Date());
        reservation.setDate_sortie((new Date()));
        reservationsServices.ajouterReservation(reservation);
        return "redirect:/";
    }



}
