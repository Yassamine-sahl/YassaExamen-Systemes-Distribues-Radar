package ma.enset.commonapi.events;

import lombok.Getter;

public class RadarCreatedEvent extends BaseEvent<String> {
    @Getter private double maxSpeed;
    @Getter private double latitude;
    @Getter private double longitude;
    public RadarCreatedEvent(String id, double maxSpeed, double latitude, double longitude) {
        super(id);
        this.maxSpeed = maxSpeed;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
