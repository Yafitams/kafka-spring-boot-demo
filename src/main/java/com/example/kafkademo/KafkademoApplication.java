package com.example.kafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkademoApplication {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    KafkademoApplication(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
//        this.kafkaTemplate.send("example", "msg");

        this.kafkaTemplate.send("example", new TestMessage());
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkademoApplication.class, args);
    }

    private static class TestMessage {
        public String msg = "text msg";
        public String id = "123456";
    }

}
