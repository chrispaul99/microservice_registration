package com.microservice.administrator.clients;


import javax.validation.Valid;

import com.common.entities.models.Subject;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-subject")
public interface ISubjectFeignClient {

	@PostMapping("/save")
	public Subject createSubject(@Valid@RequestBody Subject Subject);
}
