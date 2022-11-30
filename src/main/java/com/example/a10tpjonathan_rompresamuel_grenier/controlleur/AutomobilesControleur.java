package com.example.a10tpjonathan_rompresamuel_grenier.controlleur;

import com.example.a10tpjonathan_rompresamuel_grenier.model.Automobile;
import com.example.a10tpjonathan_rompresamuel_grenier.model.Filtres;
import com.example.a10tpjonathan_rompresamuel_grenier.service.AutomobilesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/automobile")
public class AutomobilesControleur {
    @Autowired
    private AutomobilesServices automobilesServices;

    @PostMapping("/trier")
    public String filtrerPageAcceuilParMarque(Model model, @ModelAttribute("filtres") Filtres filtres) {
        List<Automobile> listAutomobiles = automobilesServices.filtrerAutomobiles(filtres);
        model.addAttribute("listAutomobiles", listAutomobiles);
        model.addAttribute("marque", filtres.getSelectionMarque());
        model.addAttribute("filtres", filtres);

        return "Acceuil";
    }

    public AutomobilesControleur(AutomobilesServices automobilesServices) {
        this.automobilesServices = automobilesServices;
    }

    @GetMapping("/")
    public String affichageAcceuil(Model model) {

        List<Automobile> listAutomobiles = automobilesServices.listerAutomobilesDispo();
        model.addAttribute("automobile", new Automobile());
        model.addAttribute("listAutomobiles", listAutomobiles);
        // envoyer les listes pour les filtres
        Filtres filtres = new Filtres();
        filtres.setTransmission(automobilesServices.getTransmission());
        filtres.setMotopropulsion(automobilesServices.getMotopropulsion());
        filtres.setMarque(automobilesServices.getMarques());
        model.addAttribute("filtres", filtres);
        return "Acceuil";
    }

    @GetMapping("/louees")
    public String affichageAccueilLouees(Model model) {
        List<Automobile> listAutomobiles = automobilesServices.listerAutomobilesLouees();
        model.addAttribute("automobile", new Automobile());
        model.addAttribute("listAutomobiles", listAutomobiles);
        return "VoituresLouees";

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
