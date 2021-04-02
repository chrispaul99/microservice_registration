package com.microservice.administrator.services;

import java.util.List;

import com.microservice.administrator.models.Administrator;




public interface IServiceAdministrator {

	public void save(Administrator Administrator); //Create-Update
	public Administrator findById(Long id); //Retrieve
	public void delete(Long id);  //Delete
	public List<Administrator> findAll(); //List
	
	public List<Administrator> findByFirstName(String firstName);
	public List<Administrator> findByLastName(String lastName);
}
