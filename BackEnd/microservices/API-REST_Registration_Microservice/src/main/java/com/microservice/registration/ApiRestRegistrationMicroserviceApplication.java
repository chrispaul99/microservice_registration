package com.microservice.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.common.entities.models")
public class ApiRestRegistrationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestRegistrationMicroserviceApplication.class, args);
	}

}
