package repository;

import entity.CarsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<CarsEntity, Integer> {
    List<CarsEntity> findCarsEntitiesByMarkaAndTypeAndNumberOfSeatsAndIsBrokeIsFalse(String markaAuto, String type, int countOfSeats);
    CarsEntity findCarsEntitiesById(int id);
}
