package com.gfg.jbdl30session9.repository;

import com.gfg.jbdl30session9.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface OrderRepo extends CrudRepository<Order,Long> {
    Optional<Order> findByOrderId(String orderId);
}
