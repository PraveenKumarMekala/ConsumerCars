package com.connected.cars.provider;

import com.connected.cars.domain.Consumer;
import com.connected.cars.domain.FileType;
import org.springframework.cloud.openfeign.FeignClient;
import com.connected.cars.config.ProviderConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "save consumer", url = "${save-consumer.url}", configuration = ProviderConfiguration.class)
public interface BaseProvider {

    @PostMapping(value = "/api/v1/save-consumer")
    Long saveConsumer(@RequestBody Consumer consumer, @PathVariable("fileType") FileType fileType);
}
