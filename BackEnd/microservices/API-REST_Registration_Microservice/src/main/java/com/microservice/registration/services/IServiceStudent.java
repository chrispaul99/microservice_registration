package com.microservice.registration.services;

import java.util.List;

import com.microservice.registration.models.Student;



public interface IServiceStudent {

	public void save(Student student); //Create-Update
	public Student findById(Long id); //Retrieve
	public void delete(Long id);  //Delete
	public List<Student> findAll(); //List
	
	public List<Student> findByFirstName(String firstName);
	public List<Student> findByLastName(String lastName);
}
