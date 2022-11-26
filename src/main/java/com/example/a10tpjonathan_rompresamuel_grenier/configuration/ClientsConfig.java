package com.example.a10tpjonathan_rompresamuel_grenier.configuration;

import com.example.a10tpjonathan_rompresamuel_grenier.model.Client;
import com.example.a10tpjonathan_rompresamuel_grenier.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientsConfig {
    @Bean
    CommandLineRunner commandLineRunnerClient(ClientRepository clientRepository){
        return args -> {
            Client client1 = new Client("Dupont","Rémond","rdupont@aol.com");
            Client client2 = new Client("Lamonde","Karen","klamonde@lamonde.com");
            Client client3 = new Client("Divan","Yvan","dyvan@hotmail.com");
            Client client4 = new Client("DesPlanches","Clément","clement.desplanches@gmail.fr");
            Client client5 = new Client("Turloupitou","ititou","iloupitou@latoile.fr");

            clientRepository.saveAll(List.of(client1, client2, client3, client4, client5));
        };
    }
}
