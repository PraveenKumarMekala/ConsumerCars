package com.connected.cars.service;

import com.connected.cars.domain.Consumer;
import com.connected.cars.domain.FileType;
import com.connected.cars.provider.BaseProvider;
import com.connected.cars.response.ConsumerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    BaseProvider provider;

    public Long save(Consumer consumer, FileType fileType) {

        return provider.saveConsumer(consumer, fileType);
    }

    public ConsumerResponse getAllConsumers() {

        return provider.getAllConsumers();
    }

    public Consumer updateConsumer(Long id) {

        return provider.updateConsumer(id);
    }
}
