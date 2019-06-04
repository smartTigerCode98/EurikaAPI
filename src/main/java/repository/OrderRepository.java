package repository;

import entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrdersEntity, Integer> {

    List<OrdersEntity> findOrdersEntitiesByProcessedIsFalse();
    OrdersEntity findById(int id);

}
