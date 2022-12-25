package ma.enset.commonapi.events;

public class RadarCreatedEvent extends BaseEvent<String> {
    private double vitesseMax;
    private double longtitude;
    private double latitude;

    public RadarCreatedEvent(String id, double vitesseMax, double longtitude, double latitude) {
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
