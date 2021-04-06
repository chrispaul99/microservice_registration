package com.microservice.administrator.services;

import java.util.List;

import com.microservice.administrator.models.InstructiveData;





public interface IServiceInstructive {

	public void save(InstructiveData Instructive); //Create-Update
	public InstructiveData findById(Long id); //Retrieve
	public void delete(Long id);  //Delete
	public List<InstructiveData> findAll(); //List
}
