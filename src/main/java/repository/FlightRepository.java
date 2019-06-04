package repository;

import entity.FlightsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightsEntity, Integer>{

    FlightsEntity findFlightsEntitiesByIdDriverAndStatusIsFalse(int idDriver);
    FlightsEntity findFlightsEntitiesById(int idFlight);

}
