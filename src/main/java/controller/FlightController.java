package controller;

import entity.FlightsEntity;
import entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FlightService;
import service.UserService;

import java.util.Map;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private UserService userService;


    @PostMapping("/api/flights")
    public ResponseEntity<HttpStatus> createFlight(@RequestParam Map<String, String> requestParams, @RequestHeader("token") String token){
        UsersEntity usersEntity = userService.getUserByToken(token);
        if(usersEntity != null && usersEntity.getRole().equals("dispatcher") ) {
            flightService.createFlight(Integer.parseInt(requestParams.get("idOrder")),
                    Integer.parseInt(requestParams.get("idDriver")));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }


    @RequestMapping(value = "/api/flights/drivers", method = RequestMethod.GET)
    public ResponseEntity<FlightsEntity> getFlightForDriver(@RequestHeader("token") String token) {
        UsersEntity usersEntity = userService.getUserByToken(token);
        if(usersEntity != null && usersEntity.getRole().equals("driver") ) {
            return new ResponseEntity<>(flightService.findFlightForDriver(usersEntity.getId()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/api/flights/{idFlight}", method = RequestMethod.PUT)
    public ResponseEntity<HttpStatus> updateStatusFlight(@RequestParam Map<String, String> requestParams, @PathVariable("idFlight") int idFlight,
                                   @RequestHeader("token") String token){
        UsersEntity usersEntity = userService.getUserByToken(token);
        if(usersEntity != null && usersEntity.getRole().equals("driver") ) {
            flightService.updateStatusFlightAndStatusDriver(idFlight,
                    Integer.parseInt(requestParams.get("idDriver")),
                    Boolean.parseBoolean(requestParams.get("statusFlight")));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

    }

}
