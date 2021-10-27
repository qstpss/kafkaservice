package com.example.kafkaservice.services;

import external.dto.ExternalValueDto;

public interface DatabaseClientHttpClient {
    void sendExternalValue(ExternalValueDto dto);
}
