package com.microservice.administrator.repositories;

import java.util.List;

import com.microservice.administrator.models.Period;

import org.springframework.data.repository.CrudRepository;





public interface IPeriodRepository extends CrudRepository<Period, Long> {
	
	public List<Period> findByFirstName(String firstName);
	public List<Period> findByLastName(String lastName);

}
