package ma.enset.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateInfractionRequestDTO {
    private Date date;
    private double montant;
    private String vehiculeId;
    private String radarId;
}
