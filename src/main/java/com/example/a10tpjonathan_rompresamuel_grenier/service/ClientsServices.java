package com.example.a10tpjonathan_rompresamuel_grenier.service;

import com.example.a10tpjonathan_rompresamuel_grenier.model.Client;
import com.example.a10tpjonathan_rompresamuel_grenier.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientsServices {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> listerClients() {
        return clientRepository.findAll();
    }

    public void ajouterClient(Client client) {
        clientRepository.save(client);
    }

    public Client trouverClient(Integer id) {
        return clientRepository.findById(id).get();
    }


}
