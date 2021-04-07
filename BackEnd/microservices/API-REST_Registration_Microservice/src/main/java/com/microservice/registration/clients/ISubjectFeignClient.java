package com.microservice.registration.clients;

import com.common.entities.models.Registration;
import com.microservice.registration.models.RegistrationData;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-subject")
@Component
public interface ISubjectFeignClient {

	@PutMapping("/registration/{id}")
	public void asignarMatricula(@PathVariable Long id,@RequestBody Registration registration);
}
