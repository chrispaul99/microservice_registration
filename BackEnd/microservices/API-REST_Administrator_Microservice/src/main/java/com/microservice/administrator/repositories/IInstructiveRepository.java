package com.microservice.administrator.repositories;

import java.util.List;

import com.microservice.administrator.models.Instructive;

import org.springframework.data.repository.CrudRepository;





public interface IInstructiveRepository extends CrudRepository<Instructive, Long> {
	
	public List<Instructive> findByFirstName(String firstName);
	public List<Instructive> findByLastName(String lastName);

}
