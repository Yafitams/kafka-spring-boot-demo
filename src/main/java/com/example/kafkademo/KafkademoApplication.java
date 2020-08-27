package com.example.kafkademo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkademoApplication implements CommandLineRunner {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    KafkademoApplication(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkademoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.kafkaTemplate.send("example", new TestMessage());
    }

    private static class TestMessage {
        public String msg = "text msg";
        public String id = "12345";
    }

}
