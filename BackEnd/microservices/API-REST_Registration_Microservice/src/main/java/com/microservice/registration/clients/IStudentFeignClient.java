package com.microservice.registration.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-student")
public interface IStudentFeignClient {

	@DeleteMapping("/delete-matricula/{id}")
	public void eliminarAlumnoMatriculaPorId(@PathVariable Long id) ;
}
