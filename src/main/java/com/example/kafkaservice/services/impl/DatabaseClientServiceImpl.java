package com.example.kafkaservice.services.impl;

import com.example.kafkaservice.model.ExternalValueDto;
import com.example.kafkaservice.services.DatabaseClientHttpClient;
import com.example.kafkaservice.services.DatabaseClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DatabaseClientServiceImpl implements DatabaseClientService {

    private final DatabaseClientHttpClient databaseClientHttpClient;

    @Override
    public void sendExternalValue(ExternalValueDto dto) {
        databaseClientHttpClient.sendExternalValue(dto);
    }
}
