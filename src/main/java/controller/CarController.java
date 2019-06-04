package controller;

import entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CarService;
import service.UserService;

import java.util.Map;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @RequestMapping("/api/cars/{idCar}")
    @PutMapping
    public ResponseEntity<HttpStatus> updateStatusCar(@PathVariable("idCar") int idCar, @RequestParam Map<String, String> requestParams,
                                                      @RequestHeader("token") String token){
        UsersEntity usersEntity = userService.getUserByToken(token);
        if(usersEntity != null && usersEntity.getRole().equals("driver") ) {
            carService.updateStatusCar(idCar, Boolean.parseBoolean(requestParams.get("statusCar")));
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
