package com.microservice.administrator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.administrator.models.Administrator;
import com.microservice.administrator.repositories.IAdministratorRepository;



@Service
public class AdministratorService implements IServiceAdministrator{
	
	@Autowired
	private IAdministratorRepository AdministratorService;
	
	@Override
	@Transactional
	public void save(Administrator myAdministrator) {
		try {
			AdministratorService.save(myAdministrator);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Administrator findById(Long id) {
		return AdministratorService.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		try {
			AdministratorService.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Administrator> findAll() {
		return (List<Administrator>) AdministratorService.findAll();
	}


}
