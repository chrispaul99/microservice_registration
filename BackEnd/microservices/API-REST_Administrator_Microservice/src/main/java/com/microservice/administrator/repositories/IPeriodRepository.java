package com.microservice.administrator.repositories;


import com.microservice.administrator.models.Period;

import org.springframework.data.repository.CrudRepository;





public interface IPeriodRepository extends CrudRepository<Period, Long> {

}
