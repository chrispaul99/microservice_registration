package com.microservice.administrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApiRestAdministratorMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestAdministratorMicroserviceApplication.class, args);
	}

}
