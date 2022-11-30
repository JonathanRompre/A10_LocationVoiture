package com.example.a10tpjonathan_rompresamuel_grenier.controlleur;

import com.example.a10tpjonathan_rompresamuel_grenier.model.Client;
import com.example.a10tpjonathan_rompresamuel_grenier.service.ClientsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientsControleur {

    @Autowired
    private ClientsServices clientsServices;

    public ClientsControleur(ClientsServices clientsServices) {
        this.clientsServices = clientsServices;
    }

    @GetMapping
    public String affichageClients(@RequestParam(required = false) Integer autoId, Model model) {

        List<Client> listClient = clientsServices.listerClients();
        model.addAttribute("autoId", autoId);
        model.addAttribute("client", new Client());
        model.addAttribute("listClients", listClient);
        return "ListeClients";
    }

    @GetMapping("/details/{id}")
    public String updateClient(@PathVariable(value = "id") int id, Model model) {
        Client client = clientsServices.trouverClient(id);
        model.addAttribute("client", client);
        return "DetailsClients";
    }

    @PostMapping("/sauvegarder")
    public String sauvegarderClient(@ModelAttribute("client") Client client) {
        clientsServices.ajouterClient(client);
        return "redirect:/client";
    }

    @GetMapping("/ajouter")
    public String ajouterNouveauClient(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "AjouterClient";
    }
}
