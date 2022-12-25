package ma.enset.commonapi.events;

import lombok.Getter;

@Getter
public class VehiculeUpdatedEvent extends BaseEvent<String> {
    private String marque;
    private String modele;
    private String matricule;
    private String puissanceFiscale;
    private String proprietaireId;

    public VehiculeUpdatedEvent(String id, String matricule, String marque, String modele, String puissanceFiscale, String proprietaireId) {
        super(id);
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.puissanceFiscale = puissanceFiscale;
        this.proprietaireId = proprietaireId;
    }

}
