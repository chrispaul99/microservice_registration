package com.microservice.registration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.registration.clients.IStudentFeignClient;
import com.microservice.registration.models.RegistrationData;
import com.microservice.registration.repositories.IRegistrationRepository;


@Service
public class RegistrationService implements IServiceRegistration{
	
	@Autowired
	private IRegistrationRepository RegistrationService;
	@Autowired
	private IStudentFeignClient StudentService;
	
	@Override
	@Transactional
	public void save(RegistrationData myRegistration) {
		try {
			RegistrationService.save(myRegistration);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public RegistrationData findById(Long id) {
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
	public List<RegistrationData> findAll() {
		return (List<RegistrationData>) RegistrationService.findAll();
	}

	@Override
	public Iterable<RegistrationData> findAllById(Iterable<Long> ids) {
		return RegistrationService.findAllById(ids);
	}
	@Override
	public void añadirlistadoMatricula(List<RegistrationData> registrations) {
		for (RegistrationData elemento: registrations){
			RegistrationService.save(elemento);
		}
	}

}
