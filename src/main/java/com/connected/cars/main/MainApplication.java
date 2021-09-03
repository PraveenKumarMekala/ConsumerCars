package com.connected.cars.main;

import com.connected.cars.provider.BaseProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients(basePackageClasses = {BaseProvider.class})
@ComponentScan(basePackages = "com.connected.cars")
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	public Docket consumerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
                .apis(RequestHandlerSelectors.basePackage("com.connected.cars.controller"))
				.paths(PathSelectors.any())
				.build();

	}

}
