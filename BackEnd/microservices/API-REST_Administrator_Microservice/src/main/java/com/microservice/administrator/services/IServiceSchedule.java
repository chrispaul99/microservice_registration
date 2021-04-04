package com.microservice.administrator.services;

import java.util.List;

import com.microservice.administrator.models.Schedule;




public interface IServiceSchedule {

	public void save(Schedule Schedule); //Create-Update
	public Schedule findById(Long id); //Retrieve
	public void delete(Long id);  //Delete
	public List<Schedule> findAll(); //List
}
