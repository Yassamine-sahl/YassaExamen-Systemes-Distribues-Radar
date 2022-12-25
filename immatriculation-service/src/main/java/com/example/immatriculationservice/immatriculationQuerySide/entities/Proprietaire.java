package com.example.immatriculationservice.immatriculationQuerySide.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proprietaire {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private Date ddn;
    private String email;
    private String numTel;

    @OneToMany(mappedBy = "proprietaire")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Vehicule> vehicules = new ArrayList<>();
}
