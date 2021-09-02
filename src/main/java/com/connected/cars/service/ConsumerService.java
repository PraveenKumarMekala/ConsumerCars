package com.connected.cars.service;

import com.connected.cars.domain.Consumer;
import com.connected.cars.domain.FileType;
import com.connected.cars.provider.BaseProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    BaseProvider provider;

    public Long save(Consumer consumer, FileType fileType) {

        return provider.saveConsumer(consumer, fileType);
    }
}
