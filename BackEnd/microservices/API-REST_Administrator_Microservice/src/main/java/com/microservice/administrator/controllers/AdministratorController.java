package com.microservice.administrator.controllers;

import java.util.List;

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
import com.microservice.administrator.models.AdministradorData;
import com.microservice.administrator.services.IServiceAdministrator;



@RestController
@RequestMapping("/administrator")
public class AdministratorController {
	
	@Autowired
	private IServiceAdministrator service;

	@GetMapping("/message")
	public String test() {
		
		return "Hello from microservice administrator";
	}

	@GetMapping("/{id}")
	public AdministradorData retrieve(@PathVariable(value = "id") Long id){
		AdministradorData Administrator = service.findById(id);
		if (Administrator == null)
			throw new AdministratorNotFoundException(id);
		return Administrator;
	}
	
	@GetMapping
	public List<AdministradorData> list(){
		return service.findAll();
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public AdministradorData create(@RequestBody AdministradorData Administrator) {
		service.save(Administrator);
		return Administrator;
	}
	
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> update(@RequestBody AdministradorData Administrator, @PathVariable Long id) {
        AdministradorData AdministratorOptional = service.findById(id);

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
