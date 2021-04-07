package com.microservice.subject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.entities.models.Subject;
import com.microservice.subject.clients.IPeriodFeignClient;
import com.microservice.subject.models.SubjectData;
import com.microservice.subject.repositories.ISubjectRepository;


@Service
public class SubjectService implements IServiceSubject{
	
	@Autowired
	private ISubjectRepository SubjectService;

	@Autowired
	private IPeriodFeignClient PeriodService;
	
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

	@Override
	public void asignarMateria(Long id, Subject subject) {
		PeriodService.asignarMateria(id, subject);
	}

}
