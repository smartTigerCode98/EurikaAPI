package service;

import entity.CarsEntity;
import entity.DriversEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarRepository;
import repository.DriverRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CarRepository carRepository;

    public List<DriversEntity> findFreeDriversForNecessaryCarCriteria(String markAuto, String bodyType, int countOfSits) {
        List<DriversEntity> driversEntities = new ArrayList<>();
        List<CarsEntity> carsEntities = carRepository.findCarsEntitiesByMarkaAndTypeAndNumberOfSeatsAndIsBrokeIsFalse(markAuto, bodyType, countOfSits);
        if(carsEntities.size() > 0){
            for(CarsEntity carsEntity: carsEntities){
                DriversEntity driversEntity = driverRepository.findByIdCar(carsEntity.getId());
                if(driversEntity != null){
                    if(driversEntity.getIsFree()){
                        driversEntities.add(driversEntity);
                    }
                }
            }
        }

        return driversEntities;
    }

    public DriversEntity findDriver(int idDriver) {
        return driverRepository.findById(idDriver);
    }
}
