package com.example.a10tpjonathan_rompresamuel_grenier.repository;

import com.example.a10tpjonathan_rompresamuel_grenier.model.Automobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutomobilesRepository extends JpaRepository<Automobile, Integer> {

}
