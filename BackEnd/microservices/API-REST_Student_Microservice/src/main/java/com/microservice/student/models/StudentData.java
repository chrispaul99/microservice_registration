package com.microservice.student.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.common.entities.models.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "students")
public class StudentData extends Student{

    @Id
	@Column(name="id_student")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idStudent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = {"student"}, allowSetters = true)
	private List<StudentRegistration> registrations_student;

    public StudentData() {
        this.registrations_student = new ArrayList<StudentRegistration>();
    }

    public List<StudentRegistration> getRegistrations_student() {
        return registrations_student;
    }

    public void setRegistrations_student(List<StudentRegistration> registrations_student) {
        this.registrations_student = registrations_student;
    }
    public void addRegistration(StudentRegistration regis) {
		this.registrations_student.add(regis);
	}
	
	public void removeRegistration(StudentRegistration regis) {
		this.registrations_student.remove(regis);
	}

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }    
}
