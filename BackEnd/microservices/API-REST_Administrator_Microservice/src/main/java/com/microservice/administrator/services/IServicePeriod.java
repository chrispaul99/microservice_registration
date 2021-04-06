package com.microservice.administrator.services;

import java.util.List;

import com.common.entities.models.Period;
import com.microservice.administrator.models.PeriodData;




public interface IServicePeriod {

	public void save(PeriodData Period); //Create-Update
	public PeriodData findById(Long id); //Retrieve
	public void delete(Long id);  //Delete
	public List<PeriodData> findAll(); //List
}
