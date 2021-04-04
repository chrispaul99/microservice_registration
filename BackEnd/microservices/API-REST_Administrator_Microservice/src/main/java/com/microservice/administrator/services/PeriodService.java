package com.microservice.administrator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.administrator.models.Period;
import com.microservice.administrator.repositories.IPeriodRepository;



@Service
public class PeriodService implements IServicePeriod{
	
	@Autowired
	private IPeriodRepository PeriodService;
	
	@Override
	@Transactional
	public void save(Period myPeriod) {
		try {
			PeriodService.save(myPeriod);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Period findById(Long id) {
		return PeriodService.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		try {
			PeriodService.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Period> findAll() {
		return (List<Period>) PeriodService.findAll();
	}

}
