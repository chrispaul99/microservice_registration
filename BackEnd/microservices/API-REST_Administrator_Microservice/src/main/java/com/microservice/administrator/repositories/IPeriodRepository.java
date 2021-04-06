package com.microservice.administrator.repositories;


import com.microservice.administrator.models.PeriodData;

import org.springframework.data.repository.CrudRepository;





public interface IPeriodRepository extends CrudRepository<PeriodData, Long> {

}
