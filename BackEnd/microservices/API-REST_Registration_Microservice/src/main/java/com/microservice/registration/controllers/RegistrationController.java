package com.microservice.registration.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.common.entities.models.Registration;
import com.microservice.registration.exceptions.RegistrationNotFoundException;
import com.microservice.registration.services.IServiceRegistration;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Registration")
public class RegistrationController {
	
	@Autowired
	private IServiceRegistration service;
	
	@GetMapping("/{id}")
	public Registration retrieve(@PathVariable(value = "id") Long id){
		Registration Registration = service.findById(id);
		if (Registration == null)
			throw new RegistrationNotFoundException(id);
		return Registration;
	}
	
	@GetMapping
	public List<Registration> list(){
		return service.findAll();
	}
	@GetMapping("/registrations-by-student")
	public ResponseEntity<?> obtenerMatricularPorAlumno(@RequestParam List<Long> ids) {
		return ResponseEntity.ok(service.findAllById(ids));
	}
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Registration create(
			@Valid
			@RequestBody Registration Registration
		) {
		service.save(Registration);
		return Registration;
	}
	
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> update(@RequestBody Registration Registration, @PathVariable Long id) {
        Registration RegistrationOptional = service.findById(id);

        if (RegistrationOptional==null)
            return ResponseEntity.notFound().build();
        Registration.setIdRegistration(id);
        service.save(Registration);
        return ResponseEntity.ok(Registration);
    }
	
	
	@Transactional
	@DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Registration Deleted");
    }

}
