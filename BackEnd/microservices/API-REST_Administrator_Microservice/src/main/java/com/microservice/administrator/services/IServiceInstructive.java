package com.microservice.administrator.services;

import java.util.List;

import com.microservice.administrator.models.Instructive;




public interface IServiceInstructive {

	public void save(Instructive Instructive); //Create-Update
	public Instructive findById(Long id); //Retrieve
	public void delete(Long id);  //Delete
	public List<Instructive> findAll(); //List
	
	public List<Instructive> findByFirstName(String firstName);
	public List<Instructive> findByLastName(String lastName);
}
