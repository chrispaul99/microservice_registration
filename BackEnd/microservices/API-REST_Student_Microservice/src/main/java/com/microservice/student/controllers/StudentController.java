package com.microservice.student.controllers;

import java.util.List;
import java.util.stream.Collectors;

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

import com.common.entities.models.Registration;
import com.microservice.student.exceptions.StudentNotFoundException;
import com.microservice.student.models.StudentData;
import com.microservice.student.models.StudentRegistration;
import com.microservice.student.services.IServiceStudent;


@RestController
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	private IServiceStudent service;
	
	@GetMapping("/{id}")
	public StudentData retrieve(@PathVariable(value = "id") Long id){
		StudentData student = service.findById(id);
		if (student == null)
			throw new StudentNotFoundException(id);
		return student;
	}
	@DeleteMapping("/delete-matricula/{id}")
	public ResponseEntity<?> eliminarAlumnoMatriculaPorId(@PathVariable Long id) {
		
		service.eliminarMatriculaPorAlumno(id);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/registrations-by-id")
	public ResponseEntity<?> retrievebyregistrations(@PathVariable(value = "id") Long id){
		StudentData student = service.findById(id);
		if (student == null)
			throw new StudentNotFoundException(id);
		if(!student.getRegistrations_student().isEmpty()){
			List<Long> ids = student.getRegistrations_student().stream()
					.map(ca -> ca.getId()).collect(Collectors.toList());
			
			List<Registration> registrations = (List<Registration>) service.obtenerMatriculasPorStudent(ids);
			
			student.setRegistrations(registrations);
		}
		return ResponseEntity.ok().body(student);
	}

	@GetMapping("/message")
	public String test() {
		
		return "Hello from microservice student";
	}
	
	@GetMapping
	public List<StudentData> list(){
		return service.findAll();
	}

	@GetMapping("/registration")
	public ResponseEntity<?> listar()
	{
		List<StudentData> cursos = service.findAll().stream().map(c -> {
			c.getRegistrations_student().forEach(ca -> {
				Registration registration = new Registration(){};
				registration.setIdRegistration(ca.getIdRegistration());
				c.addRegistration(registration);
			});
			return c;
		}).collect(Collectors.toList());
		return ResponseEntity.ok().body(cursos);
	}
	
	@GetMapping("/listByLastName")
	public List<StudentData> listByLastname(@PathParam(value = "lastName") String lastName){
		return service.findByLastName(lastName);
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public StudentData create(
			@Valid
			@RequestBody StudentData student
		) {
		service.save(student);
		return student;
	}
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> update(@RequestBody StudentData student, @PathVariable Long id) {
        StudentData studentOptional = service.findById(id);

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
	@PutMapping("/{id}/registrations")
	public ResponseEntity<?> asignarMatriculas(@RequestBody List<Registration> registrations, @PathVariable Long id) {

		StudentData stDb = this.service.findById(id);

		if(stDb == null) {
			return ResponseEntity.notFound().build();
		}

		registrations.forEach(a -> {

			StudentRegistration registration_std = new StudentRegistration();
			registration_std.setIdRegistration(a.getIdRegistration());
			registration_std.setStudent(stDb);
			stDb.addRegistration(registration_std);
		});
		this.service.save(stDb);
		return ResponseEntity.status(HttpStatus.CREATED).body(stDb);
	}

	@PutMapping("/{id}/delete-registration")
	public ResponseEntity<?> eliminarMatricula(@RequestBody Registration registration, @PathVariable Long id) {

		StudentData stDb = this.service.findById(id);

		if(stDb == null) {
			return ResponseEntity.notFound().build();
		}
		StudentRegistration registration_std  = new StudentRegistration();
		registration_std.setIdRegistration(registration.getIdRegistration());
		stDb.removeRegistration(registration_std);
		this.service.save(stDb);
		return ResponseEntity.status(HttpStatus.CREATED).body(stDb);
	}	
}//
