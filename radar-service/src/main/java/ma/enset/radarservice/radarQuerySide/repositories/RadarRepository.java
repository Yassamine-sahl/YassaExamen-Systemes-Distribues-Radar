package ma.enset.radarservice.radarQuerySide.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import radarService.radarQuerySide.entities.Radar;

public interface RadarRepository extends JpaRepository<Radar,String> {

}
