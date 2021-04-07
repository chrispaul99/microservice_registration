package com.microservice.registration.services;

import java.util.List;

import com.common.entities.models.Registration;
import com.microservice.registration.models.RegistrationData;

public interface IServiceRegistration {

	public void save(RegistrationData Registration); //Create-Update
	public RegistrationData findById(Long id); //Retrieve
	public void delete(Long id);  //Delete
	public List<RegistrationData> findAll(); //List
	public Iterable<RegistrationData> findAllById(Iterable<Long> ids);
	public void asignarMatriculas(List<RegistrationData> registrations, Long id);
	public void asignarMatricula(Long id,Registration registration);
}
