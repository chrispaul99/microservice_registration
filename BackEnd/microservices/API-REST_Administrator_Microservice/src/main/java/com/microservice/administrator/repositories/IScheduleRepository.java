package com.microservice.administrator.repositories;

import java.util.List;

import com.microservice.administrator.models.Schedule;

import org.springframework.data.repository.CrudRepository;





public interface IScheduleRepository extends CrudRepository<Schedule, Long> {
	
	public List<Schedule> findByFirstName(String firstName);
	public List<Schedule> findByLastName(String lastName);

}
