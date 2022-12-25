package com.example.immatriculationservice.immatriculationCommandSide.aggregates;

import ma.enset.commonapi.commands.CreateVehiculeCommand;
import ma.enset.commonapi.commands.UpdateVehiculeCommand;
import ma.enset.commonapi.events.VehiculeCreatedEvent;
import ma.enset.commonapi.events.VehiculeUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class VehiculeAggregate {
    @AggregateIdentifier
    private String id;
    private String matricule;
    private String marque;
    private String modele;
    private String puissanceFiscale;
    private String proprietaireId;

    public VehiculeAggregate() {
    }

    @CommandHandler
    public VehiculeAggregate(CreateVehiculeCommand command) {
        AggregateLifecycle.apply(
                new VehiculeCreatedEvent(
                        command.getId(),
                        command.getMatricule(),
                        command.getMarque(),
                        command.getModele(),
                        command.getPuissanceFiscale(),
                        command.getProprietaireId()
                )
        );
    }

    @EventSourcingHandler
    public void on(VehiculeCreatedEvent event) {
        this.id = event.getId();
        this.matricule = event.getMatricule();
        this.marque = event.getMarque();
        this.modele = event.getModele();
        this.puissanceFiscale = event.getPuissanceFiscale();
        this.proprietaireId = event.getProprietaireId();
    }

    @CommandHandler
    public void handle(UpdateVehiculeCommand command) {
        AggregateLifecycle.apply(
                new VehiculeUpdatedEvent(
                        command.getId(),
                        command.getMatricule(),
                        command.getMarque(),
                        command.getModele(),
                        command.getPuissanceFiscale(),
                        command.getProprietaireId()
                )
        );
    }

    @EventSourcingHandler
    public void on(VehiculeUpdatedEvent event) {
        this.id = event.getId();
        this.matricule = event.getMatricule();
        this.marque = event.getMarque();
        this.modele = event.getModele();
        this.puissanceFiscale = event.getPuissanceFiscale();
        this.proprietaireId = event.getProprietaireId();
    }
}
