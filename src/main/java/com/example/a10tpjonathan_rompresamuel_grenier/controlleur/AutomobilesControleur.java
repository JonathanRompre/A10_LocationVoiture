package com.example.a10tpjonathan_rompresamuel_grenier.controlleur;

import com.example.a10tpjonathan_rompresamuel_grenier.model.Automobile;
import com.example.a10tpjonathan_rompresamuel_grenier.service.AutomobilesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/automobile")
public class AutomobilesControleur implements ErrorController {
    @Autowired
    private AutomobilesServices automobilesServices;
    @GetMapping("/trier")
    public String viewHomePage(Model model, @Param("marque") String marque) {
        List<Automobile> listAutomobiles = automobilesServices.listAll(marque);
        model.addAttribute("listAutomobiles", listAutomobiles);
        model.addAttribute("marque", marque);

        return "Acceuil";
    }

    public AutomobilesControleur(AutomobilesServices automobilesServices) {
        this.automobilesServices = automobilesServices;
    }

    @GetMapping("/")
    public String affichageAcceuil(Model model) {

        List<Automobile> listAutomobiles = automobilesServices.listerAutomobiles();
        model.addAttribute("automobile", new Automobile());
        model.addAttribute("listAutomobiles", listAutomobiles);
        return "Acceuil";
    }

    @GetMapping("/ajouterAutomobile")
    public String ajouterNouvelleAutomobile(Model model) {
        Automobile automobile = new Automobile();
        model.addAttribute("automobile", automobile);
        return "AjouterAutomobile";
    }

    @PostMapping("/sauvegarderAutomobile")
    public String sauvegarderAutomobile(@ModelAttribute("automobile") Automobile automobile) {
        automobilesServices.ajouterAutomobile(automobile);
        return "redirect:/automobile/";
    }

    @GetMapping("/detailsAutomobile/{id}")
    public String updateAutomobile(@PathVariable(value = "id") int id, Model model) {
        Automobile automobile = automobilesServices.trouverAutomobile(id);
        model.addAttribute("automobile", automobile);
        return "DetailsAutomobile";
    }

    @GetMapping("/supprimerAutomobile/{id}")
    public String supprimerAvecId(@PathVariable(value = "id") int id) {
        automobilesServices.supprimerAutomobiles(id);
        return "redirect:/automobile/";

    }

}
