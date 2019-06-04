package service;

import entity.CarsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarRepository;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public void updateStatusCar(int idCar, boolean status){
        CarsEntity carsEntity = carRepository.findCarsEntitiesById(idCar);
        carsEntity.setIsBroke(status);
        carRepository.save(carsEntity);
    }
}
