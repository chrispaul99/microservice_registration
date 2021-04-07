package com.microservice.subject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.subject.models.SubjectData;
import com.microservice.subject.repositories.ISubjectRepository;


@Service
public class SubjectService implements IServiceSubject{
	
	@Autowired
	private ISubjectRepository SubjectService;
	
	@Override
	@Transactional
	public void save(SubjectData mySubject) {
		try {
			SubjectService.save(mySubject);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public SubjectData findById(Long id) {
		return SubjectService.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		try {
			SubjectService.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<SubjectData> findAll() {
		return (List<SubjectData>) SubjectService.findAll();
	}

}
