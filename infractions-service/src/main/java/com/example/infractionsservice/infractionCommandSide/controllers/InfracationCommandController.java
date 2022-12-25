package com.example.infractionsservice.infractionCommandSide.controllers;

import lombok.AllArgsConstructor;
import ma.enset.commonapi.commands.CreateInfractionCommand;
import ma.enset.commonapi.commands.UpdateInfractionCommand;
import ma.enset.commonapi.dtos.CreateInfractionRequestDTO;
import ma.enset.commonapi.dtos.UpdateInfractionRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/infraction/commands")
@AllArgsConstructor
@CrossOrigin("*")
public class InfracationCommandController {
    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createInfraction(@RequestBody CreateInfractionRequestDTO createInfractionRequestDTO) {
        return commandGateway.send(new CreateInfractionCommand(
                UUID.randomUUID().toString(),
                createInfractionRequestDTO.getDate(),
                createInfractionRequestDTO.getMontant(),
                createInfractionRequestDTO.getVehiculeId(),
                createInfractionRequestDTO.getRadarId()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateInfraction(@RequestBody UpdateInfractionRequestDTO updateInfractionRequestDTO) {
        return commandGateway.send(new UpdateInfractionCommand(
                updateInfractionRequestDTO.getId(),
                updateInfractionRequestDTO.getDate(),
                updateInfractionRequestDTO.getMontant(),
                updateInfractionRequestDTO.getVehiculeId(),
                updateInfractionRequestDTO.getRadarId()
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
