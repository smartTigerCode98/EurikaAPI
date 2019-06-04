package controller;

import entity.DriversEntity;
import entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.DriverService;
import service.UserService;

import java.util.List;
import java.util.Map;

@RestController
public class DriversController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private UserService userService;

    @RequestMapping("/api/drivers")
    @GetMapping
    public ResponseEntity<List<DriversEntity>> getFreeDriversByAutoCriteria(@RequestParam Map<String, String> requestParams,
                                                                            @RequestHeader("token") String token) {
        UsersEntity usersEntity = userService.getUserByToken(token);
        if(usersEntity != null && usersEntity.getRole().equals("dispatcher") ) {
            List<DriversEntity> driversEntities = driverService.findFreeDriversForNecessaryCarCriteria(requestParams.get("markaAuto"),
                    requestParams.get("bodyType"),
                    Integer.parseInt(requestParams.get("countOfSits")));
            if (driversEntities != null) {
                return new ResponseEntity<>(driversEntities, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping("/api/drivers/{idDriver}")
    @GetMapping
    public ResponseEntity<DriversEntity> getDriver(@PathVariable("idDriver") int idDriver, @RequestHeader("token") String token){

        UsersEntity usersEntity = userService.getUserByToken(token);
        if(usersEntity != null && usersEntity.getRole().equals("dispatcher") ) {
            DriversEntity driversEntity = driverService.findDriver(idDriver);
            if (driversEntity != null) {
                return new ResponseEntity<>(driverService.findDriver(idDriver), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}
