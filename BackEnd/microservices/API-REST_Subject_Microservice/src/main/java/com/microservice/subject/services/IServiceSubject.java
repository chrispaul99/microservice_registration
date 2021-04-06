package com.microservice.subject.services;

import java.util.List;

import com.common.subject.models.entity.Subject;




public interface IServiceSubject {

	public void save(Subject Subject); //Create-Update
	public Subject findById(Long id); //Retrieve
	public void delete(Long id);  //Delete
	public List<Subject> findAll(); //List
}
