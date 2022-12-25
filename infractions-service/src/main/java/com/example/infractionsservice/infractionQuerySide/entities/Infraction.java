package com.example.infractionsservice.infractionQuerySide.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Infraction {
    @Id
    private String id;
    private Date date;
    private double montant;
    private String vehiculeId;
    private String radarId;

    @Transient
    private Vehicule vehicule;

    @Transient
    private Radar radar;
}
