package com.common.entities.models;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
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
	
	@NotNull
	@Column(name="status")
	private Boolean status;
	
	//@Transient
	//private Period period;
	@Transient
	private Subject subject;
	
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

	public Long getIdRegistration() {
		return idRegistration;
	}

	public void setIdRegistration(Long idRegistration) {
		this.idRegistration = idRegistration;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	//public Period getPeriod() {
	//	return period;
	//}
//
	//public void setPeriod(Period period) {
	//	this.period = period;
	//}
//
	
	
	
	
	
}
