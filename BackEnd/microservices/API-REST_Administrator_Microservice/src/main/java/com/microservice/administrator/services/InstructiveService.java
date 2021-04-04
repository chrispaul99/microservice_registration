package com.microservice.administrator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.administrator.models.Instructive;
import com.microservice.administrator.repositories.IInstructiveRepository;



@Service
public class InstructiveService implements IServiceInstructive{
	
	@Autowired
	private IInstructiveRepository InstructiveService;
	
	@Override
	@Transactional
	public void save(Instructive myInstructive) {
		try {
			InstructiveService.save(myInstructive);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Instructive findById(Long id) {
		return InstructiveService.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		try {
			InstructiveService.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Instructive> findAll() {
		return (List<Instructive>) InstructiveService.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Instructive> findByFirstName(String firstName) {
		return InstructiveService.findByFirstName(firstName);
	}


	@Override
	@Transactional(readOnly = true)
	public List<Instructive> findByLastName(String lastName) {
		return InstructiveService.findByLastName(lastName);
	}


}
