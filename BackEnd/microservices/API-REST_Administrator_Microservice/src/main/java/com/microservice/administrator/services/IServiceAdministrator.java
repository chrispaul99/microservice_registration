package com.microservice.administrator.services;

import java.util.List;

import com.microservice.administrator.models.AdministradorData;




public interface IServiceAdministrator {

	public void save(AdministradorData Administrator); //Create-Update
	public AdministradorData findById(Long id); //Retrieve
	public void delete(Long id);  //Delete
	public List<AdministradorData> findAll(); //List
}
