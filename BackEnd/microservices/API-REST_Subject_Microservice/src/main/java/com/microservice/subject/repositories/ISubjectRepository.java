package com.microservice.subject.repositories;

import org.springframework.data.repository.CrudRepository;

import com.microservice.subject.models.Subject;



public interface ISubjectRepository extends CrudRepository<Subject, Long> {
	
}
