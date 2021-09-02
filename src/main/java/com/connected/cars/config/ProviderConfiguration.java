package com.connected.cars.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProviderConfiguration{

    private String accessTokenUri;

    private String clientId;

    private String clientSecret;
}
