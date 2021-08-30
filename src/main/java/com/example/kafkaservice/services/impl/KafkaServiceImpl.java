package com.example.kafkaservice.services.impl;

import com.example.kafkaservice.model.ExternalValueDto;
import com.example.kafkaservice.services.DatabaseClientService;
import com.example.kafkaservice.services.KafkaService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {

    @Value("${service.name}")
    private String source;

    private final DatabaseClientService databaseClientService;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @Override
    @KafkaListener(topics = "${kafka.topic}", groupId = "#{T(java.util.UUID).randomUUID().toString()}")
    public void consume(@Payload String message, @Header("payloadType")String payloadType) {
        System.out.println("Received a value");
        if (!payloadType.equals(ExternalValueDto.class.getName())){
            // todo when ExternalValueDto will be in lib
        }
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);

        ExternalValueDto dto = objectMapper.readValue(message, ExternalValueDto.class);
        dto.setSource(source);
        databaseClientService.sendExternalValue(dto);
    }
}
