package com.microservice.student.repositories;

import java.util.List;

import com.microservice.student.models.StudentData;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;




public interface IStudentRepository extends CrudRepository<StudentData, Long> {
	
	public List<StudentData> findByFirstName(String firstName);
	public List<StudentData> findByLastName(String lastName);
	
	@Modifying
	@Query("SELECT st FROM StudentRegistration st WHERE st.idRegistration =?1")
	public void eliminarMatriculaPorAlumno(Long id);

}
