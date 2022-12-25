package com.example.immatriculationservice.immatriculationQuerySide.repositories;


import immatriculationService.immatriculationQuerySide.entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietaireRepository extends JpaRepository<Proprietaire, String> {
}
