package com.example.kafkaservice.services.impl;

import com.example.kafkaservice.model.ExternalValueDto;
import com.example.kafkaservice.services.DatabaseClientService;
import com.example.kafkaservice.services.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {

    @Value("${service.name}")
    private String source;

    private final DatabaseClientService databaseClientService;

    @Override
    @KafkaListener(topics = "${kafka.topic}", groupId = "#{T(java.util.UUID).randomUUID().toString()}")
    public void consume(ExternalValueDto dto) {
        System.out.println("Received a value");
        dto.setSource(source);
        databaseClientService.sendExternalValue(dto);
    }
}
