package com.microservice.subject.clients;



import com.common.entities.models.Subject;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-administrator")
@Component
public interface IPeriodFeignClient {

	@PutMapping("/period/{id}/subject")
	public void asignarMateria( @PathVariable Long id, @RequestBody Subject subject);
}
