package ma.enset.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UpdateVehiculeRequestDTO {
    private String id;
    private String matricule;
    private String marque;
    private String modele;
    private String puissanceFiscale;
    private String proprietaireId;
}