package com.microservice.registration.repositories;

import java.util.List;

import com.microservice.registration.models.Registration;

import org.springframework.data.repository.CrudRepository;




public interface IRegistrationRepository extends CrudRepository<Registration, Long> {
	
	public List<Registration> findByFirstName(String firstName);
	public List<Registration> findByLastName(String lastName);

}
