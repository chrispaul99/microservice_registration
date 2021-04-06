package com.common.entities.models;


import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public abstract class Registration{
	
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
	
	//@OneToOne(cascade = CascadeType.ALL)		
	//@JoinColumn(name = "fk_subject", referencedColumnName = "id_subject")
	//private Subject subject;
//
	//@OneToOne(cascade = CascadeType.ALL)		
	//@JoinColumn(name = "fk_period", referencedColumnName = "id_period")
	//private Period period;
	
	
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



	//public Subject getSubject() {
	//	return subject;
	//}

	//public void setSubject(Subject subject) {
	//	this.subject = subject;
	//}

	
	
	
	
	
}
