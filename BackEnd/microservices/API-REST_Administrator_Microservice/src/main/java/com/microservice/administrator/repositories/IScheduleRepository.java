package com.microservice.administrator.repositories;

import java.util.List;

import com.common.entities.models.Schedule;
import com.microservice.administrator.models.ScheduleData;

import org.springframework.data.repository.CrudRepository;





public interface IScheduleRepository extends CrudRepository<ScheduleData, Long> {
	

}
