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

import com.microservice.administrator.exceptions.AdministratorNotFoundException;
import com.microservice.administrator.models.Administrator;
import com.microservice.administrator.services.IServiceAdministrator;



@RestController
@RequestMapping("/administrator")
public class AdministratorController {
	
	@Autowired
	private IServiceAdministrator service;
	
	@GetMapping("/{id}")
	public Administrator retrieve(@PathVariable(value = "id") Long id){
		Administrator Administrator = service.findById(id);
		if (Administrator == null)
			throw new AdministratorNotFoundException(id);
		return Administrator;
	}
	
	@GetMapping
	public List<Administrator> list(){
		return service.findAll();
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Administrator create(
			@Valid
			@RequestBody Administrator Administrator
		) {
		service.save(Administrator);
		return Administrator;
	}
	
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> update(@RequestBody Administrator Administrator, @PathVariable Long id) {
        Administrator AdministratorOptional = service.findById(id);

        if (AdministratorOptional==null)
            return ResponseEntity.notFound().build();
        Administrator.setIdAdministrator(id);
        service.save(Administrator);
        return ResponseEntity.ok(Administrator);
    }
	
	
	@Transactional
	@DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        service.delete(id);
		return ResponseEntity.ok().build();
    }

}
