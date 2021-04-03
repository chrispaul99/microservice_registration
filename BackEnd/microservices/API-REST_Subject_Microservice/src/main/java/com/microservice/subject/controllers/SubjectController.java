package com.microservice.subject.controllers;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/subject")
public class SubjectController {
	@GetMapping("/message")
	public String test() {
		
		return "Hello from microservice subject";
	}
}
