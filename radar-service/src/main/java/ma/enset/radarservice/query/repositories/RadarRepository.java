package ma.enset.radarservice.query.repositories;


import ma.enset.radarservice.query.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar, String> {
}
