package com.microservice.student.services;

import java.util.List;

import com.common.entities.models.Registration;
import com.microservice.student.models.StudentData;

public interface IServiceStudent {

	public void save(StudentData student); //Create-Update
	public StudentData findById(Long id); //Retrieve
	public void delete(Long id);  //Delete
	public List<StudentData> findAll(); //List
	public List<StudentData> findByFirstName(String firstName);
	public List<StudentData> findByLastName(String lastName);
	public Iterable<Registration> obtenerMatriculasPorStudent(List<Long> ids);
	public void eliminarMatriculaPorAlumno(Long id);
}
