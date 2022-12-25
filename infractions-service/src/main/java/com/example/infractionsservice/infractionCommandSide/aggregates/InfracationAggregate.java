package com.example.infractionsservice.infractionCommandSide.aggregates;

import ma.enset.commonapi.commands.CreateInfractionCommand;
import ma.enset.commonapi.commands.UpdateInfractionCommand;
import ma.enset.commonapi.events.InfractionCreatedEvent;
import ma.enset.commonapi.events.InfractionUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
public class InfracationAggregate {
    @AggregateIdentifier
    private String id;
    private Date date;
    private double montant;
    private String vehiculeId;
    private String radarId;

    public InfracationAggregate() {
    }

    @CommandHandler
    public InfracationAggregate(CreateInfractionCommand command) {
        AggregateLifecycle.apply(new InfractionCreatedEvent(
                command.getId(),
                command.getDate(),
                command.getMontant(),
                command.getVehiculeId(),
                command.getRadarId()
        ));
    }

    @EventSourcingHandler
    public void on(InfractionCreatedEvent event) {
        this.id = event.getId();
        this.date = event.getDate();
        this.montant = event.getMontant();
        this.vehiculeId = event.getVehiculeId();
        this.radarId = event.getRadarId();
    }

    @CommandHandler
    public void handle(UpdateInfractionCommand command) {
        AggregateLifecycle.apply(new InfractionUpdatedEvent(
                command.getId(),
                command.getDate(),
                command.getMontant(),
                command.getVehiculeId(),
                command.getRadarId()
        ));
    }

    @EventSourcingHandler
    public void on(InfractionUpdatedEvent event) {
        this.id = event.getId();
        this.date = event.getDate();
        this.montant = event.getMontant();
        this.vehiculeId = event.getVehiculeId();
        this.radarId = event.getRadarId();
    }
}
