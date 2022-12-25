package ma.enset.commonapi.commands;

import java.util.Date;

public class UpdateInfractionCommand extends BaseCommand<String>{
    private Date date;
    private double montant;
    private String vehiculeId;
    private String radarId;

    public UpdateInfractionCommand(String id, Date date, double montant, String vehiculeId, String radarId) {
        super(id);
        this.date = date;
        this.montant = montant;
        this.vehiculeId = vehiculeId;
        this.radarId = radarId;
    }

    public Date getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public String getVehiculeId() {
        return vehiculeId;
    }

    public String getRadarId() {
        return radarId;
    }
}
