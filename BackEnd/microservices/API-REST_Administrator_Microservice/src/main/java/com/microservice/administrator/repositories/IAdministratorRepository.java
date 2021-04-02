package com.microservice.administrator.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.microservice.administrator.models.Administrator;




public interface IAdministratorRepository extends CrudRepository<Administrator, Long> {
	
	public List<Administrator> findByFirstName(String firstName);
	public List<Administrator> findByLastName(String lastName);

}
