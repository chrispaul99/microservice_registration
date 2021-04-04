package com.microservice.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApiRestStudentMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestStudentMicroserviceApplication.class, args);
	}

}
