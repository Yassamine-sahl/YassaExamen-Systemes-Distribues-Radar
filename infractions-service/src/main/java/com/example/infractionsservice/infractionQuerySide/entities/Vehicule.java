package com.example.infractionsservice.infractionQuerySide.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Vehicule {
    private String id;
    private String marque;
    private String modele;
    private String matricule;
    private String puissanceFiscale;
    private String proprietaireId;
}
