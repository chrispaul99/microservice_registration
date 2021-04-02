package com.microservice.student.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.microservice.student.models.Student;



public interface IStudentRepository extends CrudRepository<Student, Long> {
	
	public List<Student> findByFirstName(String firstName);
	public List<Student> findByLastName(String lastName);

}
