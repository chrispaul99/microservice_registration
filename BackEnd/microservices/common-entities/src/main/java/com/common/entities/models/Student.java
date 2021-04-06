package com.common.entities.models;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Student extends Person {
		
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

	@Transient
	List<Registration> registrations;

	//@OneToOne(cascade = CascadeType.ALL)		
	//@JoinColumn(name = "fk_user", referencedColumnName = "id")
	//private User user;

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
	public void addRegistration(Registration regis) {
		this.registrations.add(regis);
	}
	
	public void removeRegistration(Registration regis) {
		this.registrations.remove(regis);
	}

	//public User getUser() {
	//	return user;
	//}
	//public void setUser(User user) {
	//	this.user = user;
	//}
	
}
