package com.microservice.student.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Table(name = "Students")
@Entity
public class Student extends Person {
	
	@Id
	@Column(name="id_student")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idStudent;
	
	@NotEmpty(message = "Ingrese la carrera asignada")
	@NotNull
	@Size(min = 2, message = "La carrera asignada debe tener al menos 2 caracteres")
	@Column(name="assigned_career")
	private String assigned_career;
	
	@NotNull
	@Column(name="num_credit")
	private Integer num_credit;

	@NotEmpty(message = "Ingrese el tipo de estudiante")
	@NotNull
	@Size(max= 1, message = "El tipo de estudiante es Z, C o T")
	@Column(name="type")
	private String type;
	
	@NotNull
	@Column(name="registration_line")
	private Boolean registration_line;
	
	@NotNull
	@Column(name="status")
	private Boolean status;
	
	
	public Student() {
		super();
	}
	public Student(Long idStudent) {
		super();
		this.idStudent = idStudent;
	}
	public Long getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}
	public String getAssigned_career() {
		return assigned_career;
	}
	public void setAssigned_career(String assigned_career) {
		this.assigned_career = assigned_career;
	}
	public Boolean getRegistration_line() {
		return registration_line;
	}
	public void setRegistration_line(Boolean registration_line) {
		this.registration_line = registration_line;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public int getNum_credit() {
		return num_credit;
	}
	public void setNum_credit(int num_credit) {
		this.num_credit = num_credit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
