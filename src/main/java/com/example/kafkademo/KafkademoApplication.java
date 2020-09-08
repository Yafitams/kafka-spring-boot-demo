package com.example.kafkademo;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.function.Consumer;
import java.util.stream.Stream;

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
    public void run(String... args) {
        Consumer<Integer> kafkaProduceMessage = partition ->
            kafkaTemplate.send(new ProducerRecord<>("example", partition, null, new TestMessage(partition)));

        Stream.of(0, 1, 2).forEach(kafkaProduceMessage);
    }

    private static class TestMessage {
        public String fname = "Jane";
        public String lname = "Doe";
        public int partition;

        TestMessage(int partition) {
            this.partition = partition;
        }
    }

}
