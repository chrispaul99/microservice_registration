package com.microservice.administrator.clients;


import javax.validation.Valid;

import com.common.entities.models.Subject;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-subject")
@Component
public interface ISubjectFeignClient {

	//@PostMapping("/save")
	//public Iterable<Subject> createSubject(@Valid@RequestBody Subject Subject);
}
