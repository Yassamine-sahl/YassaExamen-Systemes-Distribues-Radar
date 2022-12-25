package com.example.immatriculationservice.immatriculationCommandSide.controllers;

import lombok.AllArgsConstructor;
import ma.enset.commonapi.commands.CreateProprietaireCommand;
import ma.enset.commonapi.commands.UpdateProprietaireCommand;
import ma.enset.commonapi.dtos.CreateProprietaireRequestDTO;
import ma.enset.commonapi.dtos.UpdateProprietaireRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/proprietaire/commands")
@AllArgsConstructor
@CrossOrigin("*")
public class ProprietaireCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createProprietaire(@RequestBody CreateProprietaireRequestDTO request) {
        return commandGateway.send(new CreateProprietaireCommand(
                UUID.randomUUID().toString(),
                request.getNom(),
                request.getPrenom(),
                request.getDdn(),
                request.getEmail(),
                request.getNumTel()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateProprietaire(@RequestBody UpdateProprietaireRequestDTO request) {
        return commandGateway.send(new UpdateProprietaireCommand(
                request.getId(),
                request.getNom(),
                request.getPrenom(),
                request.getDdn(),
                request.getEmail(),
                request.getNumTel()
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        ResponseEntity<String> entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }

    @GetMapping("/eventStore/{id}")
    public Stream getEventStore(@PathVariable String id) {
        return eventStore.readEvents(id).asStream();
    }

}
