package ma.enset.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRadarRequestDTO {
    private String id;
    private double vitesseMax;
    private double longtitude;
    private double latitude;
}
