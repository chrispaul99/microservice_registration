package com.microservice.registration.clients;

import com.microservice.registration.models.RegistrationData;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-administrator")
public interface IPeriodFeignClient {

	@PutMapping("/period/registrations")
	public void asignarMatricula(@RequestBody RegistrationData registration);
}
