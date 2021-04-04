package com.microservice.administrator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.administrator.models.Schedule;
import com.microservice.administrator.repositories.IScheduleRepository;



@Service
public class ScheduleService implements IServiceSchedule{
	
	@Autowired
	private IScheduleRepository ScheduleService;
	
	@Override
	@Transactional
	public void save(Schedule mySchedule) {
		try {
			ScheduleService.save(mySchedule);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Schedule findById(Long id) {
		return ScheduleService.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		try {
			ScheduleService.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Schedule> findAll() {
		return (List<Schedule>) ScheduleService.findAll();
	}

}
