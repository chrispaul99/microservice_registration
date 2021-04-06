package com.microservice.registration.models;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.common.student.models.entity.Student;

import org.springframework.format.annotation.DateTimeFormat;


@Table(name = "Registrations")
@Entity
public class Registration{
	
	@Id
	@Column(name="id_registration")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRegistration;

	@Column(name="date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Calendar date;
	
	@NotEmpty(message = "Ingrese el tipo")
	@NotNull
	@Size(max = 1, message = "El tipo debe ser primera, segunda o tercera")
	@Column(name="type")
	private String type;
	
	@NotNull
	@Column(name="paytotal")
	private Double paytotal;
	
	@NotEmpty(message = "Ingrese el estado")
	@NotNull
	@Column(name="status")
	private Boolean status;

	@JoinColumn(name="fk_student",referencedColumnName="id_student")
	@ManyToOne
	private Student student;
	 

	public Registration() {
	}

	public Registration(Long idRegistration) {
		this.idRegistration = idRegistration;
	}

	public Long getIdRegistration() {
		return idRegistration;
	}

	public void setIdRegistration(Long idRegistration) {
		this.idRegistration = idRegistration;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPaytotal() {
		return paytotal;
	}

	public void setPaytotal(Double paytotal) {
		this.paytotal = paytotal;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	
	
	
	
	
}
