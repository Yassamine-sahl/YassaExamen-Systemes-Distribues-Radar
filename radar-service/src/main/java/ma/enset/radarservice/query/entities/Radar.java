package ma.enset.radarservice.query.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Radar {
    @Id private String id;
    private double maxSpeed;
    private double latitude;
    private double longitude;
}
