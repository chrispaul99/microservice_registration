package com.common.entities.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	@OneToMany(mappedBy="student",fetch=FetchType.LAZY)
		private List<Registration> registrations; 
	
	@OneToOne(cascade = CascadeType.ALL)		
	@JoinColumn(name = "fk_user", referencedColumnName = "id")
	private User user;
	
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setNum_credit(Integer num_credit) {
		this.num_credit = num_credit;
	}
	public List<Registration> getRegistrations() {
		return registrations;
	}
	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
