package com.example.a10tpjonathan_rompresamuel_grenier.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultControleur {

    @GetMapping
    public String accueilRedirect(){
        return "redirect:/automobile/";
    }
}
