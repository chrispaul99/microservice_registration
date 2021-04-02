package com.microservice.administrator.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public abstract class Person {
	
	@NotEmpty(message = "Ingrese sus nombres")
	@NotNull
	@Size(min = 2, message = "La carrera asignada debe tener al menos 2 caracteres")
	@Column(name="first_name")
	private String firstName;
	
	@NotEmpty(message = "Ingrese sus apellidos")
	@NotNull
	@Size(min = 2, message = "El lugar de nacimiento debe tener al menos 2 caracteres")
	@Column(name="last_name")
	private String lastName;
	
	@NotEmpty(message = "Ingrese el lugar de nacimiento")
	@NotNull
	@Size(min = 2, message = "El lugar de nacimiento debe tener al menos 2 caracteres")
	@Column(name="place_of_birth")
	private String placeofBirth;
	
	@Column(name="birth")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Calendar birth;
	
	@NotEmpty(message = "Ingrese el numero de cedula")
	@NotNull
	@Size(max = 10, message = "El numero de cedula no debe ser superior a 10")
	@Column(name="number_card_Id")
	private String numberCardId;
	
	@NotEmpty(message = "Ingrese el sexo")
	@NotNull
	@Column(name="sex", length=1)
	private String sex;
	
	@NotEmpty(message = "Ingrese el numero de telefono")
	@NotNull
	@Column(name="phone", length=15)
	private String phone;

	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPlaceofBirth() {
		return placeofBirth;
	}
	public void setPlaceofBirth(String placeofBirth) {
		this.placeofBirth = placeofBirth;
	}
	public Calendar getBirth() {
		return birth;
	}
	public void setBirth(Calendar birth) {
		this.birth = birth;
	}
	public String getNumberCardId() {
		return numberCardId;
	}
	public void setNumberCardId(String numberCardId) {
		this.numberCardId = numberCardId;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return this.firstName+ " "+this.lastName;
	}
	
	
	
}
