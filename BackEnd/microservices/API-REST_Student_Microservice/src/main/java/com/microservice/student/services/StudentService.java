package com.microservice.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.entities.models.Registration;
import com.microservice.student.clients.IRegistrationFeignClient;
import com.microservice.student.models.StudentData;
import com.microservice.student.repositories.IStudentRepository;


@Service
public class StudentService implements IServiceStudent{
	
	@Autowired
	private IStudentRepository StudentService;

	@Autowired
	private IRegistrationFeignClient registrationStudent;
	
	@Override
	@Transactional
	public void save(StudentData myStudent) {
		try {
			StudentService.save(myStudent);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public StudentData findById(Long id) {
		return StudentService.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		try {
			StudentService.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<StudentData> findAll() {
		return (List<StudentData>) StudentService.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<StudentData> findByFirstName(String firstName) {
		return StudentService.findByFirstName(firstName);
	}


	@Override
	@Transactional(readOnly = true)
	public List<StudentData> findByLastName(String lastName) {
		return StudentService.findByLastName(lastName);
	
	}
	@Override
	public Iterable<Registration> obtenerMatriculasPorStudent(List<Long> ids) {
		return registrationStudent.obtenerMatriculasPorAlumno(ids);
	
	}
	@Override
	public void eliminarMatriculaPorAlumno(Long id) {
		StudentService.eliminarMatriculaPorAlumno(id);
		
	}


}
