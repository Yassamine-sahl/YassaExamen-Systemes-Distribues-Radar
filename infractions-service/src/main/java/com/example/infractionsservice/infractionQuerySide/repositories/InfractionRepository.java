package com.example.infractionsservice.infractionQuerySide.repositories;

import com.example.infractionsservice.infractionQuerySide.entities.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfractionRepository extends JpaRepository<Infraction,String> {

}
