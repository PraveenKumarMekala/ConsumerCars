package com.connected.cars.service;

import com.connected.cars.domain.Consumer;
import com.connected.cars.domain.FileType;
import com.connected.cars.encyption.CryptoUtils;
import com.connected.cars.provider.BaseProvider;
import com.connected.cars.response.ConsumerResponse;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import static com.connected.cars.encyption.EncryptAndDecrypt.*;

@Service
public class ConsumerService {

    @Autowired
    BaseProvider provider;

    public Long save(Consumer consumer, FileType fileType) {
        Long response = null;
        try {
            val encryptedObject = encryptedObject(consumer);
            response = provider.saveConsumer(encryptedObject, fileType);
        } catch (Exception e) {
            // TODO: Add Logger

        }
        return response;

    }

    public ConsumerResponse getAllConsumers() {
        List<Consumer> response = null;
        try {
            val consumerArray = provider.getAllConsumers();
            response = decryptConsumers(consumerArray, CryptoUtils.getAESKey(256), CryptoUtils.getRandomNonce(12));
        } catch (Exception e) {
            // TODO: Add Logger
        }

        return ConsumerResponse.builder().consumers(response).build();
    }

    public Consumer updateConsumer(Long id) {
        Consumer consumer = null;
        try {
            val consumerArray = provider.updateConsumer(id);
            consumer = decryptConsumer(consumerArray, CryptoUtils.getAESKey(256), CryptoUtils.getRandomNonce(12));

        } catch (Exception e) {
            // TODO: Add Logger
        }

        return consumer;
    }

}
