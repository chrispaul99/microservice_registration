package com.microservice.registration.services;

import java.util.List;

import com.common.entities.models.Registration;



public interface IServiceRegistration {

	public void save(Registration Registration); //Create-Update
	public Registration findById(Long id); //Retrieve
	public void delete(Long id);  //Delete
	public List<Registration> findAll(); //List
}
