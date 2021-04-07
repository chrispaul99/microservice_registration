package com.microservice.subject.repositories;

import com.microservice.subject.models.SubjectData;

import org.springframework.data.repository.CrudRepository;




public interface ISubjectRepository extends CrudRepository<SubjectData, Long> {

	
}
