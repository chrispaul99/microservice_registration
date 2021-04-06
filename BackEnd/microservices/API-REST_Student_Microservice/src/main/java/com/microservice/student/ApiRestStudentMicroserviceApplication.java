package com.microservice.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
//@EntityScan({"com.common.entities.models"})
public class ApiRestStudentMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestStudentMicroserviceApplication.class, args);
	}

}
