package com.microservice.administrator.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.microservice.administrator.exceptions.PeriodNotFoundException;
import com.microservice.administrator.models.Administrator;
import com.microservice.administrator.models.Instructive;
import com.microservice.administrator.models.Period;
import com.microservice.administrator.services.IServiceAdministrator;
import com.microservice.administrator.services.IServiceInstructive;
import com.microservice.administrator.services.IServicePeriod;


@RestController
@RequestMapping("/period")
public class PeriodController {
	
	@Autowired
	private IServicePeriod service;
	@Autowired
	private IServiceInstructive serviceinstructive;
	@Autowired
	private IServiceAdministrator serviceadmin;
	
	@GetMapping("/{id}")
	public Period retrieve(@PathVariable(value = "id") Long id){
		Period Period = service.findById(id);
		if (Period == null)
			throw new PeriodNotFoundException(id);
		return Period;
	}
	
	@GetMapping
	public List<Period> list(){
		return service.findAll();
	}
	
	/**REGISTRAR EL PERIODO CUANDO YA CAMBIO EL ESTADO DEL INSTRUCTIVO */
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> create(@Valid@RequestBody Period Period) {
		Instructive ins = serviceinstructive.findById(Period.getInstructive().getIdInstructive());
		Administrator admin = serviceadmin.findById(Period.getAdministrator().getIdAdministrator());
		if(ins!=null && admin!=null){
			Period.setAdministrator(admin);
			Period.setInstructive(ins);
			service.save(Period);
		return ResponseEntity.ok(Period);
		}
		return ResponseEntity.notFound().build();
		
	}
	
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> update(@RequestBody Period Period, @PathVariable Long id) {
        Period PeriodOptional = service.findById(id);

        if (PeriodOptional==null)
            return ResponseEntity.notFound().build();
        Period.setIdPeriod(id);
        service.save(Period);
        return ResponseEntity.ok(Period);
    }
	
	
	@Transactional
	@DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        service.delete(id);
		return ResponseEntity.ok().build();
    }

}
