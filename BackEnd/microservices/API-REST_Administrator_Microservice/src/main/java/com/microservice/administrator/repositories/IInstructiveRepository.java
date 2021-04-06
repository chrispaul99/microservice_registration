package com.microservice.administrator.repositories;


import com.microservice.administrator.models.InstructiveData;

import org.springframework.data.repository.CrudRepository;


public interface IInstructiveRepository extends CrudRepository<InstructiveData, Long> {

}
