package com.gfg.jbdl30session9;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@RestController
public class Controller {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private OrderRepo orderRepo;

    @PostMapping("/user")
    void create(@RequestBody UserReq userReq){
        User user = new User();
        user.setUserName(userReq.getUserName());
        user.setPhone(userReq.getPhone());
        user.setEmail(userReq.getEmail());
        userRepository.save(user);
    }

    @PostMapping("/order")
    void create(@RequestBody OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setOrderDate(new Date());
        User user = userRepository.findById(orderRequest.getUserId()).get();
        order.setUser(user);
        Item item = itemRepo.findById(orderRequest.getItem()).get();
        order.setItems(Arrays.asList(item));
        orderRepo.save(order);
    }
}
