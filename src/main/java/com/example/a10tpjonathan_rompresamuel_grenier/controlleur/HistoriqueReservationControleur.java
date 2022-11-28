package com.example.a10tpjonathan_rompresamuel_grenier.controlleur;

import com.example.a10tpjonathan_rompresamuel_grenier.model.Reservation;
import com.example.a10tpjonathan_rompresamuel_grenier.service.HistoriqueReservationsServices;
import com.example.a10tpjonathan_rompresamuel_grenier.service.ReservationsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/retour")
public class HistoriqueReservationControleur {

    @Autowired
    private HistoriqueReservationsServices historiqueReservationsServices;
    @Autowired
    private ReservationsServices reservationsServices;


    public HistoriqueReservationControleur(HistoriqueReservationsServices historiqueReservationsServices, ReservationsServices reservationsServices){
        this.historiqueReservationsServices = historiqueReservationsServices;
        this.reservationsServices = reservationsServices;
    }

    @GetMapping
    public String effectuerRetourVoiture(@RequestParam int autoId, Model model){

        Reservation tmpReservation = reservationsServices.findReservationByAutoId(autoId);
        historiqueReservationsServices.ajouterHistoriqueReservation(tmpReservation);

        return "redirect:/";
    }
}
