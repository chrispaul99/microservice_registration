package com.microservice.subject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.microservice.subject.models.Subject;



public interface ISubjectRepository extends CrudRepository<Subject, Long> {
	
	public List<Subject> findByFirstName(String firstName);
	public List<Subject> findByLastName(String lastName);

}
