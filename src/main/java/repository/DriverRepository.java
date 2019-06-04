package repository;

import entity.DriversEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<DriversEntity, Integer> {
    DriversEntity findByIdCar(int idCar);
    DriversEntity findById(int id);
}
