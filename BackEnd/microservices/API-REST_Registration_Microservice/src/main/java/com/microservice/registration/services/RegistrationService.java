package com.microservice.registration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.entities.models.Registration;
import com.microservice.registration.repositories.IRegistrationRepository;


@Service
public class RegistrationService implements IServiceRegistration{
	
	@Autowired
	private IRegistrationRepository RegistrationService;
	
	@Override
	@Transactional
	public void save(Registration myRegistration) {
		try {
			RegistrationService.save(myRegistration);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Registration findById(Long id) {
		return RegistrationService.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		try {
			RegistrationService.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Registration> findAll() {
		return (List<Registration>) RegistrationService.findAll();
	}

}
