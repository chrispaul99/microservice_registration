package com.microservice.administrator.repositories;

import java.util.List;

import com.common.entities.models.Schedule;

import org.springframework.data.repository.CrudRepository;





public interface IScheduleRepository extends CrudRepository<Schedule, Long> {
	

}
