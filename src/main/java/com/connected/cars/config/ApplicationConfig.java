package com.connected.cars.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    @ConfigurationProperties("client-properties")
    public ClientProperties clientProperties() {
        return new ClientProperties();
    }
}
