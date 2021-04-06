package com.microservice.student.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "students_registrations")
public class StudentRegistration {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_registration", unique = true)
	private Long idRegistration;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_student",referencedColumnName="id_student")
	@JsonIgnoreProperties(value = {"studentsRegistrations"})
	private StudentData student;
	//@ManyToOne

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(Long idRegistration) {
        this.idRegistration = idRegistration;
    }

    public StudentData getStudent() {
        return student;
    }

    public void setStudent(StudentData student) {
        this.student = student;
    }

    @Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentRegistration)) {
			return false;
		}

		StudentRegistration ca = (StudentRegistration) obj;

		return this.idRegistration != null && this.idRegistration.equals(ca.getIdRegistration());
	}
    
}
