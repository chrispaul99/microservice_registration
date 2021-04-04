package com.microservice.subject.controllers;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.subject.exceptions.SubjectNotFoundException;
import com.microservice.subject.models.Subject;
import com.microservice.subject.services.IServiceSubject;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	private IServiceSubject service;
	
	@GetMapping("/{id}")
	public Subject retrieve(@PathVariable(value = "id") Long id){
		Subject Subject = service.findById(id);
		if (Subject == null)
			throw new SubjectNotFoundException(id);
		return Subject;
	}
	@GetMapping("/message")
	public String test() {
		
		return "Hello from microservice Subject";
	}
	
	@GetMapping
	public List<Subject> list(){
		return service.findAll();
	}
	
	@GetMapping("/listByLastName")
	public List<Subject> listByLastname(@PathParam(value = "lastName") String lastName){
		return service.findByLastName(lastName);
	}
	
	
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Subject create(
			@Valid
			@RequestBody Subject Subject
		) {
		service.save(Subject);
		return Subject;
	}
	
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> update(@RequestBody Subject Subject, @PathVariable Long id) {
        Subject SubjectOptional = service.findById(id);

        if (SubjectOptional==null)
            return ResponseEntity.notFound().build();
        Subject.setIdSubject(id);
        service.save(Subject);
        return ResponseEntity.ok(Subject);
    }
	
	
	@Transactional
	@DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Subject Deleted");
    }

}
