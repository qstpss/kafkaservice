package com.example.kafkaservice.services;

import com.example.kafkaservice.model.ExternalValueDto;

public interface DatabaseClientService {
    void sendExternalValue(ExternalValueDto dto);
}
