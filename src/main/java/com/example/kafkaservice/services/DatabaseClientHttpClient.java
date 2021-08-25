package com.example.kafkaservice.services;


import com.example.kafkaservice.model.ExternalValueDto;

public interface DatabaseClientHttpClient {
    void sendExternalValue(ExternalValueDto dto);
}
