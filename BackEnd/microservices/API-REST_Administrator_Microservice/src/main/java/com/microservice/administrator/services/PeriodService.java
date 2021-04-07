package com.microservice.administrator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.entities.models.Subject;
import com.microservice.administrator.clients.ISubjectFeignClient;
import com.microservice.administrator.models.PeriodData;
import com.microservice.administrator.repositories.IPeriodRepository;



@Service
public class PeriodService implements IServicePeriod{
	
	@Autowired
	private IPeriodRepository PeriodService;

	
	@Override
	@Transactional
	public void save(PeriodData myPeriod) {
		try {
			PeriodService.save(myPeriod);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public PeriodData findById(Long id) {
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
	public List<PeriodData> findAll() {
		return (List<PeriodData>) PeriodService.findAll();
	}

}
