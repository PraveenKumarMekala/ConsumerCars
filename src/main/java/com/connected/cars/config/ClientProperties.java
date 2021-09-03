package com.connected.cars.config;

import feign.auth.BasicAuthRequestInterceptor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

@Getter
@Setter
public class ClientProperties {

    private String clientId;

    private String clientSecret;

    /*@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(clientId, clientSecret);
    }*/
}
