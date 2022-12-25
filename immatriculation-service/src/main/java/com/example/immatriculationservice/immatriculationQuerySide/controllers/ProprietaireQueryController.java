package com.example.immatriculationservice.immatriculationQuerySide.controllers;

import com.example.examen_blanc.commonApi.query.GetAllProprietairesQuery;
import com.example.examen_blanc.commonApi.query.GetProprietaireById;
import immatriculationService.immatriculationQuerySide.entities.Proprietaire;
import immatriculationService.immatriculationQuerySide.repositories.ProprietaireRepository;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/proprietaire/queries")
@CrossOrigin("*")
public class ProprietaireQueryController {
    private QueryGateway queryGateway;
    private ProprietaireRepository proprietaireRepository;

    @GetMapping("/allProprietaires")
    public List<Proprietaire> getAllProprietaires() {
        return queryGateway.query(new GetAllProprietairesQuery(), ResponseTypes.multipleInstancesOf(Proprietaire.class)).join();
    }

    @QueryHandler
    public List<Proprietaire> on(GetAllProprietairesQuery query) {
        return proprietaireRepository.findAll();
    }

    @GetMapping("/getProprietaire/{id}")
    public Proprietaire getProprietaire(@PathVariable String id) {
        return queryGateway.query(new GetProprietaireById(id),ResponseTypes.instanceOf(Proprietaire.class)).join();
    }

    @QueryHandler
    public Proprietaire on(GetProprietaireById query) {
        return proprietaireRepository.findById(query.getId()).orElse(null);
    }
}
