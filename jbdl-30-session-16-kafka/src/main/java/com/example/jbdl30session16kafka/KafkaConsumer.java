package com.example.jbdl30session16kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "football", groupId = "app")
    void listen(String message){
        log.info("kafka has produced : {}",message);
    }

}
