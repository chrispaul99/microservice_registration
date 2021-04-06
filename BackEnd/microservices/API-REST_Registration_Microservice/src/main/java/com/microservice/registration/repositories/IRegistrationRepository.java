package com.microservice.registration.repositories;

import java.util.List;

import com.microservice.registration.models.RegistrationData;

import org.springframework.data.repository.CrudRepository;




public interface IRegistrationRepository extends CrudRepository<RegistrationData, Long> {
	
	public Iterable<RegistrationData> findAllById(Iterable<Long> ids);

}
