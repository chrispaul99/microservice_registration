package com.microservice.subject.services;

import java.util.List;

import com.microservice.subject.models.Subject;



public interface IServiceSubject {

	public void save(Subject Subject); //Create-Update
	public Subject findById(Long id); //Retrieve
	public void delete(Long id);  //Delete
	public List<Subject> findAll(); //List
	
	public List<Subject> findByFirstName(String firstName);
	public List<Subject> findByLastName(String lastName);
}
