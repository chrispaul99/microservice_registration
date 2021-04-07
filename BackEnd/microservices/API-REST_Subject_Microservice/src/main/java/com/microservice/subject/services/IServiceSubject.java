package com.microservice.subject.services;

import java.util.List;

import com.microservice.subject.models.SubjectData;




public interface IServiceSubject {

	public void save(SubjectData Subject); //Create-Update
	public SubjectData findById(Long id); //Retrieve
	public void delete(Long id);  //Delete
	public List<SubjectData> findAll(); //List
}
