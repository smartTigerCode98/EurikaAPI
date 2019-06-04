package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.DriversEntity;
import entity.FlightsEntity;
import entity.OrdersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DriverRepository;
import repository.FlightRepository;
import repository.OrderRepository;


@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DriverRepository driverRepository;

    public boolean createFlight(int idOrder, int idDriver){
        FlightsEntity flightsEntity = new FlightsEntity(idOrder, idDriver, false);
        flightRepository.save(flightsEntity);
        OrdersEntity ordersEntity = orderRepository.findById(idOrder);
        ordersEntity.setProcessed(true);
        orderRepository.save(ordersEntity);
        DriversEntity driversEntity = driverRepository.findById(idDriver);
        driversEntity.setIsFree(false);
        driverRepository.save(driversEntity);
        return true;
    }

    public FlightsEntity findFlightForDriver(int idDriver) {
        return flightRepository.findFlightsEntitiesByIdDriverAndStatusIsFalse(idDriver);
    }

    public FlightsEntity findFlightById(int id){
        return flightRepository.findFlightsEntitiesById(id);
    }

    public void updateStatusFlightAndStatusDriver(int idFlight, int idDriver, boolean statusFlight){
        FlightsEntity flightsEntity = findFlightById(idFlight);
        flightsEntity.setStatus(statusFlight);
        flightRepository.save(flightsEntity);
        DriversEntity driversEntity = driverRepository.findById(idDriver);
        driversEntity.setIsFree(true);
        driverRepository.save(driversEntity);
    }
}
