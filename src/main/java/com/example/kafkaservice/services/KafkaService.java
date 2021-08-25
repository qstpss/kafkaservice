package com.example.kafkaservice.services;

import com.example.kafkaservice.model.ExternalValueDto;

public interface KafkaService {
    void consume(ExternalValueDto dto);
}
