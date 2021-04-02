package com.microservice.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.student.models.Student;
import com.microservice.student.repositories.IStudentRepository;


@Service
public class StudentService implements IServiceStudent{
	
	@Autowired
	private IStudentRepository StudentService;
	
	@Override
	@Transactional
	public void save(Student myStudent) {
		try {
			StudentService.save(myStudent);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Student findById(Long id) {
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
	public List<Student> findAll() {
		return (List<Student>) StudentService.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Student> findByFirstName(String firstName) {
		return StudentService.findByFirstName(firstName);
	}


	@Override
	@Transactional(readOnly = true)
	public List<Student> findByLastName(String lastName) {
		return StudentService.findByLastName(lastName);
	}


}
