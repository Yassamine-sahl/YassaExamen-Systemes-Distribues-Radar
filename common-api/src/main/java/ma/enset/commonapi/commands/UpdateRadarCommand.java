package ma.enset.commonapi.commands;

public class UpdateRadarCommand extends BaseCommand<String>{
    private double vitesseMax;
    private double longtitude;
    private double latitude;

    public UpdateRadarCommand(String id, double vitesseMax, double longtitude, double latitude) {
        super(id);
        this.vitesseMax = vitesseMax;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public double getVitesseMax() {
        return vitesseMax;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
