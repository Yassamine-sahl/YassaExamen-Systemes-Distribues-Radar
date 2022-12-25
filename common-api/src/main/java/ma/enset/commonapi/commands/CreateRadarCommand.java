package ma.enset.commonapi.commands;

import lombok.Getter;

public class CreateRadarCommand extends BaseCommand<String> {
    @Getter public double maxSpeed;
    @Getter public double latitude;
    @Getter public double longitude;
    public CreateRadarCommand(String id, double maxSpeed, double latitude, double longitude) {
        super(id);
        this.maxSpeed = maxSpeed;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
