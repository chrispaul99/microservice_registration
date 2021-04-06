package com.microservice.student.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import com.common.student.models.entity.Student;
import com.microservice.student.exceptions.StudentNotFoundException;
import com.microservice.student.services.IServiceStudent;


@RestController
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	private IServiceStudent service;
	
	@GetMapping("/{id}")
	public Student retrieve(@PathVariable(value = "id") Long id){
		Student student = service.findById(id);
		if (student == null)
			throw new StudentNotFoundException(id);
		return student;
	}
	@GetMapping("/message")
	@PreAuthorize("hasRole('ADMIN')")
	public String test() {
		
		return "Hello from microservice student";
	}
	
	@GetMapping
	public List<Student> list(){
		return service.findAll();
	}
	
	@GetMapping("/listByLastName")
	public List<Student> listByLastname(@PathParam(value = "lastName") String lastName){
		return service.findByLastName(lastName);
	}
	
	
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Student create(
			@Valid
			@RequestBody Student student
		) {
		service.save(student);
		return student;
	}
	
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> update(@RequestBody Student student, @PathVariable Long id) {
        Student studentOptional = service.findById(id);

        if (studentOptional==null)
            return ResponseEntity.notFound().build();
        student.setIdStudent(id);
        service.save(student);
        return ResponseEntity.ok(student);
    }
	
	
	@Transactional
	@DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
