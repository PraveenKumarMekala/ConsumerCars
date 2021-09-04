package com.connected.cars.provider;

import com.connected.cars.config.ClientProperties;
import com.connected.cars.domain.Consumer;
import com.connected.cars.domain.FileType;
import com.connected.cars.response.ConsumerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "save-consumer", url = "${save-consumer.url}", configuration = ClientProperties.class)
public interface BaseProvider {

    @PostMapping(value = "/api/v1/save-consumer")
    Long saveConsumer(@RequestBody byte[] consumer, @PathVariable("fileType") FileType fileType);

    @GetMapping(value = "/api/v1/fetch-consumers")
    byte[] getAllConsumers();

    @PutMapping(value = "/api/v1/update-consumer")
    byte[] updateConsumer(@PathVariable("id") Long id);
}
