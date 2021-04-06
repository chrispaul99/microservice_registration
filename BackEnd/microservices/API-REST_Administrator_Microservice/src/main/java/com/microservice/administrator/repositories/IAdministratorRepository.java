package com.microservice.administrator.repositories;

import com.microservice.administrator.models.AdministradorData;

import org.springframework.data.repository.CrudRepository;




public interface IAdministratorRepository extends CrudRepository<AdministradorData, Long> {

}
