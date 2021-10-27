package com.example.kafkaservice.services;

public interface KafkaService {
    void consume(String message, String payloadType);
}
