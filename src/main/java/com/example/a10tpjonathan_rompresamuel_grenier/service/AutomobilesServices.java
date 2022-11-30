package com.example.a10tpjonathan_rompresamuel_grenier.service;

import com.example.a10tpjonathan_rompresamuel_grenier.model.Automobile;
import com.example.a10tpjonathan_rompresamuel_grenier.model.Filtres;
import com.example.a10tpjonathan_rompresamuel_grenier.model.Reservation;
import com.example.a10tpjonathan_rompresamuel_grenier.repository.AutomobilesRepository;
import com.example.a10tpjonathan_rompresamuel_grenier.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AutomobilesServices {
    @Autowired
    private AutomobilesRepository automobilesRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public List<Automobile> listerAutomobiles() {
        return automobilesRepository.findAll();
    }

    public List<Automobile> listerAutomobilesDispo() {
        List<Automobile> listAuto = automobilesRepository.findAll();
        List<Reservation> listReservation = reservationRepository.findAll();
        if (!listReservation.isEmpty()) {
            for (int i = 0; i < listAuto.size(); i++) {
                for (Reservation r : listReservation) {
                    if (listAuto.get(i).getId() == r.getAutomobileId()) {
                        listAuto.remove(i);
                    }
                }
            }
            return listAuto;
        } else {
            return listAuto;
        }
    }

    public List<Automobile> listerAutomobilesLouees() {
        List<Reservation> listReservation = reservationRepository.findAll();
        List<Automobile> listAutoLouees = new ArrayList<>();

        for (Reservation r : listReservation) {
            if (automobilesRepository.existsById(r.getAutomobileId())) {
                listAutoLouees.add(automobilesRepository.findById(r.getAutomobileId()).get());
            }
        }
        return listAutoLouees;
    }

    public void ajouterAutomobile(Automobile automobile) {
        automobilesRepository.save(automobile);
    }

    public Automobile trouverAutomobile(Integer id) {
        return automobilesRepository.findById(id).get();
    }

    public void supprimerAutomobiles(Integer id) {
        if (automobilesRepository.existsById(id)) {
            automobilesRepository.deleteById(id);
        }
    }

    public List<String> getMarques() {
        String query = "SELECT distinct p.marque from Automobile p";
        List<String> tmpList = entityManager.createQuery(query).getResultList();

        return tmpList;
    }

    public List<String> getMotopropulsion() {
        String query = "SELECT distinct p.motopropulsion from Automobile p";
        List<String> tmpList = entityManager.createQuery(query).getResultList();

        return tmpList;
    }

    public List<String> getTransmission() {
        String query = "SELECT distinct p.transmission from Automobile p";
        List<String> tmpList = entityManager.createQuery(query).getResultList();

        return tmpList;
    }

    public List<Automobile> filtrerAutomobiles(Filtres filtres) {
        boolean isFirstFilter = true;
        StringBuilder query = new StringBuilder("SELECT p from Automobile p ");

        // Au moins 1 filtre utilisé.
        if (filtres.isFilterUsed()) {
            query.append("WHERE ");
            if (!filtres.getSelectionMarque().isBlank()) {
                if (isFirstFilter) {
                    isFirstFilter = false;
                } else {
                    query.append("AND ");
                }
                query.append("p.marque LIKE '%");
                query.append(filtres.getSelectionMarque());
                query.append("%' ");
            }
            if (!filtres.getSelectionMotopropulsion().isBlank()) {
                if (isFirstFilter) {
                    isFirstFilter = false;
                } else {
                    query.append("AND ");
                }
                query.append("p.motopropulsion LIKE '%");
                query.append(filtres.getSelectionMotopropulsion());
                query.append("%' ");
            }
            if (!filtres.getSelectionTransmission().isBlank()) {
                if (isFirstFilter) {
                    isFirstFilter = false;
                } else {
                    query.append("AND ");
                }
                query.append("p.transmission LIKE '%");
                query.append(filtres.getSelectionTransmission());
                query.append("%' ");
            }
            // filtre prix max
            if (filtres.getSelectionPrixMax() != null) {
                if (isFirstFilter) {
                    isFirstFilter = false;
                } else {
                    query.append("AND ");
                }
                query.append("p.prix < ");
                query.append(filtres.getSelectionPrixMax());
            }
        }
        List<Automobile> tmpList = entityManager.createQuery(query.toString()).getResultList();
        return tmpList;
    }
}
