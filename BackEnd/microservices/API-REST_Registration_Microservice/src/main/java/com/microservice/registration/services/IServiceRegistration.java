package com.microservice.registration.services;

import java.util.List;

import com.microservice.registration.models.Registration;



public interface IServiceRegistration {

	public void save(Registration Registration); //Create-Update
	public Registration findById(Long id); //Retrieve
	public void delete(Long id);  //Delete
	public List<Registration> findAll(); //List
	
	public List<Registration> findByFirstName(String firstName);
	public List<Registration> findByLastName(String lastName);
}
