package com.example.kafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkademoApplication {

	private final KafkaTemplate<String, String> kafkaTemplate;

    KafkademoApplication(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
		this.kafkaTemplate.send("example","msg");
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkademoApplication.class, args);
    }

}
