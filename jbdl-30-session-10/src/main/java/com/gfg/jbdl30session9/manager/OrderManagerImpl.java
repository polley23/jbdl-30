package com.gfg.jbdl30session9.manager;

import com.gfg.jbdl30session9.entity.Item;
import com.gfg.jbdl30session9.entity.Order;
import com.gfg.jbdl30session9.entity.User;
import com.gfg.jbdl30session9.model.OrderRequest;
import com.gfg.jbdl30session9.model.OrderResponse;
import com.gfg.jbdl30session9.repository.ItemRepo;
import com.gfg.jbdl30session9.repository.OrderRepo;
import com.gfg.jbdl30session9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@Service
public class OrderManagerImpl implements OrderManager{
    @Autowired
    UserRepository userRepository;
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    OrderRepo orderRepo;

    @Override
    public String createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setOrderDate(new Date());
        User user = userRepository.findById(orderRequest.getUserId()).get();
        order.setUser(user);
        Item item = itemRepo.findById(orderRequest.getItem()).get();
        order.setItems(Arrays.asList(item));
        orderRepo.save(order);
        return order.getOrderId();
    }

    @Override
    public OrderResponse get(String orderId) throws Exception {
        Order order = orderRepo.findByOrderId(orderId).orElseThrow(()->new Exception("order id not found"));
        return OrderResponse.builder()
                .orderDate(order.getOrderDate())
                .items(order.getItems())
                .userId(order.getUser().getUserName())
                .build();
    }
}
