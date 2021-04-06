package com.microservice.subject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.common.subject.models.entity"})
public class ApiRestSubjectMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestSubjectMicroserviceApplication.class, args);
	}

}
