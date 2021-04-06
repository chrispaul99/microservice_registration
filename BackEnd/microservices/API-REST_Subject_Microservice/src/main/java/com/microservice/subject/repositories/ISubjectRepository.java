package com.microservice.subject.repositories;

import com.common.entities.models.Subject;

import org.springframework.data.repository.CrudRepository;




public interface ISubjectRepository extends CrudRepository<Subject, Long> {
	
}
