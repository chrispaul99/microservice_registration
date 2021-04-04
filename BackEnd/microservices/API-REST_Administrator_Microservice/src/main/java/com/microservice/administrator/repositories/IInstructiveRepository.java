package com.microservice.administrator.repositories;

import com.microservice.administrator.models.Instructive;

import org.springframework.data.repository.CrudRepository;


public interface IInstructiveRepository extends CrudRepository<Instructive, Long> {

}
