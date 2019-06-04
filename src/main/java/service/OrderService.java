package service;

import entity.OrdersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<OrdersEntity> getUnprocessedOrders() {
        return orderRepository.findOrdersEntitiesByProcessedIsFalse();
    }
}
