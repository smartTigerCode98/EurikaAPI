package controller;

import entity.OrdersEntity;
import entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.OrderService;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<OrdersEntity>> getUnprocessedOrders(@RequestHeader("token") String token){
        UsersEntity usersEntity = userService.getUserByToken(token);
        if(usersEntity != null && usersEntity.getRole().equals("dispatcher") ) {
            return new ResponseEntity<>(orderService.getUnprocessedOrders(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
