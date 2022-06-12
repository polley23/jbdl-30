package com.example.jbdl30session16kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @PostMapping("/event")
    void post(@RequestParam("message") String message){
        kafkaTemplate.send("football","key", message);
    }
}
