package com.microservice.subject.repositories;

import com.common.entities.models.Subject;
import com.microservice.subject.models.SubjectData;

import org.springframework.data.repository.CrudRepository;




public interface ISubjectRepository extends CrudRepository<SubjectData, Long> {
	
}
