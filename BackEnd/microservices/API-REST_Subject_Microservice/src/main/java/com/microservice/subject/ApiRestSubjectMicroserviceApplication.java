package com.microservice.subject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApiRestSubjectMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestSubjectMicroserviceApplication.class, args);
	}

}
