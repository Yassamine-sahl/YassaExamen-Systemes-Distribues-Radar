package ma.enset.commonapi.commands;

public class UpdateVehiculeCommand extends BaseCommand<String>{
    private String matricule;
    private String marque;
    private String modele;
    private String puissanceFiscale;
    private String proprietaireId;

    public UpdateVehiculeCommand(String id, String matricule, String marque, String modele, String puissanceFiscale, String proprietaireId) {
        super(id);
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.puissanceFiscale = puissanceFiscale;
        this.proprietaireId = proprietaireId;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getPuissanceFiscale() {
        return puissanceFiscale;
    }

    public String getProprietaireId() {
        return proprietaireId;
    }
}
