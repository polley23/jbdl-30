package com.gfg.jbdl30session9.controller;

import com.gfg.jbdl30session9.manager.OrderManager;
import com.gfg.jbdl30session9.manager.UserManagr;
import com.gfg.jbdl30session9.model.OrderRequest;
import com.gfg.jbdl30session9.model.OrderResponse;
import com.gfg.jbdl30session9.model.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class Controller {

    @Autowired
    UserManagr userManagr;
    @Autowired
    OrderManager orderManager;

    @PostMapping("/user")
    void create(@RequestBody UserReq userReq){
        userManagr.addUser(userReq);
    }

    @PostMapping("/order")
    ResponseEntity create(@RequestBody OrderRequest orderRequest){
        ResponseEntity responseEntity  = ResponseEntity.status(HttpStatus.CREATED)
                .body(orderManager.createOrder(orderRequest));
        return responseEntity;

    }

    @GetMapping("/order/{order_id}")
    ResponseEntity get(@PathVariable("order_id") String orderId){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(orderManager.get(orderId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid order id");
        }

    }
}
