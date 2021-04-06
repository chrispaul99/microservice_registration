package com.microservice.student.repositories;

import java.util.List;

import com.common.student.models.entity.Student;

import org.springframework.data.repository.CrudRepository;




public interface IStudentRepository extends CrudRepository<Student, Long> {
	
	public List<Student> findByFirstName(String firstName);
	public List<Student> findByLastName(String lastName);

}
