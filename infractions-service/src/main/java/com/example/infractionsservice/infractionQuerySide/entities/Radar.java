package com.example.infractionsservice.infractionQuerySide.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Radar {
    private String id;
    private double vitesseMax;
    private double longtitude;
    private double latitude;
}
