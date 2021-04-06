package com.microservice.student.clients;

import java.util.List;

import com.common.entities.models.Registration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "microservice-registration")
public interface IRegistrationFeignClient {

	@GetMapping("/registrations-by-student")
	public Iterable<Registration> obtenerMatriculasPorAlumno(@RequestParam List<Long> ids);
}
