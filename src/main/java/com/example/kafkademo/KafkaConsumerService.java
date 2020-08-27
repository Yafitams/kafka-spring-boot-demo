package com.example.kafkademo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "example", groupId = "group1")
    public void consumer(String message) {
        System.out.println(message);
    }
}
