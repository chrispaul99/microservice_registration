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

import com.common.entities.models.Administrator;
import com.common.entities.models.Instructive;
import com.common.entities.models.Period;
import com.common.entities.models.Subject;
import com.microservice.administrator.exceptions.PeriodNotFoundException;
import com.microservice.administrator.models.AdministradorData;
import com.microservice.administrator.models.InstructiveData;
import com.microservice.administrator.models.PeriodData;
import com.microservice.administrator.models.PeriodSubject;
import com.microservice.administrator.models.ScheduleData;
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
	public PeriodData retrieve(@PathVariable(value = "id") Long id){
		PeriodData Period = service.findById(id);
		if (Period == null)
			throw new PeriodNotFoundException(id);
		return Period;
	}
	
	@GetMapping
	public List<PeriodData> list(){
		return service.findAll();
	}
	
	/**REGISTRAR EL PERIODO CUANDO YA CAMBIO EL ESTADO DEL INSTRUCTIVO */
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> create(@Valid@RequestBody PeriodData Period) {
		InstructiveData ins = serviceinstructive.findById(Period.getInstructive().getIdInstructive());
		AdministradorData admin = serviceadmin.findById(Period.getAdministrator().getIdAdministrator());
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
	public ResponseEntity<Object> update(@RequestBody PeriodData Period, @PathVariable Long id) {
        PeriodData PeriodOptional = service.findById(id);
        if (PeriodOptional==null)
            return ResponseEntity.notFound().build();
        Period.setIdPeriod(id);
        service.save(Period);
        return ResponseEntity.ok(Period);
    }

	@PutMapping("/schedule/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> createSchedule(@RequestBody ScheduleData schedule, @PathVariable Long id) {
        PeriodData PeriodOptional = service.findById(id);
        if (PeriodOptional==null)
            return ResponseEntity.notFound().build();
        PeriodOptional.setSchedule(schedule);
        service.save(PeriodOptional);
        return ResponseEntity.ok(PeriodOptional);
    }
	
	
	@Transactional
	@DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        service.delete(id);
		return ResponseEntity.ok().build();
    }

	@PutMapping("/{id}/subject")
	public ResponseEntity<?> asignarMateria( @PathVariable Long id, @RequestBody Subject subject) {
		PeriodData pdDb=this.service.findById(1L);
		if(pdDb == null) {
			return ResponseEntity.notFound().build();
		}
		PeriodSubject subject_std = new PeriodSubject();
		subject_std.setIdSubject(subject.getIdSubject());
		subject_std.setPeriod(pdDb);
		pdDb.addSubject(subject_std);
		this.service.save(pdDb);
		return ResponseEntity.status(HttpStatus.CREATED).body(subject);
	}
}
