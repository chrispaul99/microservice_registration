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

import com.common.entities.models.Schedule;
import com.microservice.administrator.exceptions.ScheduleNotFoundException;
import com.microservice.administrator.models.ScheduleData;
import com.microservice.administrator.services.IServiceSchedule;



@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private IServiceSchedule service;
	
	@GetMapping("/{id}")
	public Schedule retrieve(@PathVariable(value = "id") Long id){
		Schedule Schedule = service.findById(id);
		if (Schedule == null)
			throw new ScheduleNotFoundException(id);
		return Schedule;
	}
	
	@GetMapping
	public List<ScheduleData> list(){
		return service.findAll();
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public ScheduleData create(
			@Valid
			@RequestBody ScheduleData Schedule
		) {
		service.save(Schedule);
		return Schedule;
	}
	
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> update(@RequestBody ScheduleData Schedule, @PathVariable Long id) {
        Schedule ScheduleOptional = service.findById(id);

        if (ScheduleOptional==null)
            return ResponseEntity.notFound().build();
        Schedule.setIdSchedule(id);
        service.save(Schedule);
        return ResponseEntity.ok(Schedule);
    }
	
	
	@Transactional
	@DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
