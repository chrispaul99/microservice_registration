package com.microservice.administrator.services;

import java.util.List;

import com.microservice.administrator.models.Period;




public interface IServicePeriod {

	public void save(Period Period); //Create-Update
	public Period findById(Long id); //Retrieve
	public void delete(Long id);  //Delete
	public List<Period> findAll(); //List
}
