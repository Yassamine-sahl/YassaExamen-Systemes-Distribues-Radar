package com.example.immatriculationservice.immatriculationQuerySide.repositories;


import immatriculationService.immatriculationQuerySide.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, String> {
}

