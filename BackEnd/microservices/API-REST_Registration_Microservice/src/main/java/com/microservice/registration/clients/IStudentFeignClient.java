package com.microservice.registration.clients;


import java.util.List;
import com.microservice.registration.models.RegistrationData;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-student")
public interface IStudentFeignClient {

	@PutMapping("/addRegistrations/{id}")
	public void añadirAlumnoMatriculaPorId(@PathVariable Long id, @RequestBody List<RegistrationData> registrations) ;
}
