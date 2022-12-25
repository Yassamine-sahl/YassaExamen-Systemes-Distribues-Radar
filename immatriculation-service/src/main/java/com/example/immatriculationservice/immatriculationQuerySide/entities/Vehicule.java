package com.example.immatriculationservice.immatriculationQuerySide.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Vehicule {
    @Id
    private String id;
    private String marque;
    private String modele;
    private String matricule;
    private String puissanceFiscale;

    @ManyToOne
    private Proprietaire proprietaire;
}
