package com.microservice.administrator.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.common.entities.models.Instructive;
import com.microservice.administrator.exceptions.InstructiveNotFoundException;
import com.microservice.administrator.models.InstructiveData;
import com.microservice.administrator.services.IServiceInstructive;



@RestController
@RequestMapping("/instructive")
public class InstructiveController {
	
	@Autowired
	private IServiceInstructive service;
	
	@GetMapping("/{id}")
	public InstructiveData retrieve(@PathVariable(value = "id") Long id){
		InstructiveData Instructive = service.findById(id);
		if (Instructive == null)
			throw new InstructiveNotFoundException(id);
		return Instructive;
	}
	
	@GetMapping
	public List<InstructiveData> list(){
		return service.findAll();
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public InstructiveData create(
			@Valid
			@RequestBody InstructiveData Instructive
		) {
		service.save(Instructive);
		return Instructive;
	}
	
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> update(@RequestBody InstructiveData Instructive, @PathVariable Long id) {
        InstructiveData InstructiveOptional = service.findById(id);

        if (InstructiveOptional==null)
            return ResponseEntity.notFound().build();
        Instructive.setIdInstructive(id);
        service.save(Instructive);
        return ResponseEntity.ok(Instructive);
    }
	
	
	@Transactional
	@DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        service.delete(id);
		return ResponseEntity.ok().build();
    }

}
