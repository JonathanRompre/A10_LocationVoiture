package com.example.a10tpjonathan_rompresamuel_grenier.configuration;

import com.example.a10tpjonathan_rompresamuel_grenier.model.Automobile;
import com.example.a10tpjonathan_rompresamuel_grenier.repository.AutomobilesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AutomobilesConfig {
    @Bean
    CommandLineRunner commandLineRunner(AutomobilesRepository automobilesRepository) {
        return args -> {

            Automobile automobile1 = new Automobile(2022, "Mazda", "CX-30", "Traction", "Automatique", "F156M68", 522.39);
            Automobile automobile2 = new Automobile(2021, "Audi", "A4", "AWD", "Automatique", "F157K36", 707.32);
            Automobile automobile3 = new Automobile(2020, "Dodge", "Ram 1500", "4X4", "Manuelle", "F365H45", 698.45);
            Automobile automobile4 = new Automobile(2019, "Hyundai", "Kona", "Traction", "Automatique", "F345X67", 322.68);
            Automobile automobile5 = new Automobile(2022, "Toyota", "RAV4", "AWD", "Manuelle", "F867Y12", 597.65);


            automobilesRepository.saveAll(List.of(automobile1, automobile2, automobile3, automobile4, automobile5));

        };
    }
}
