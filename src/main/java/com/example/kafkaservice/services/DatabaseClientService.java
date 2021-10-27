package com.example.kafkaservice.services;

import external.dto.ExternalValueDto;

public interface DatabaseClientService {
    void sendExternalValue(ExternalValueDto dto);
}
