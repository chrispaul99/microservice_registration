package com.microservice.administrator.services;

import java.util.List;

import com.common.entities.models.Schedule;
import com.microservice.administrator.models.ScheduleData;



public interface IServiceSchedule {

	public void save(ScheduleData Schedule); //Create-Update
	public ScheduleData findById(Long id); //Retrieve
	public void delete(Long id);  //Delete
	public List<ScheduleData> findAll(); //List
}
