package com.microservice.administrator.models;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


public class Period {
	@Id
	@Column(name="id_period")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idInstructive;
	
	@Column(name="start_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Calendar start_date;
	
	@Column(name="end_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Calendar end_date;
	
	@NotEmpty(message = "Ingrese el cronograma")
	@NotNull
	@Column(name="schedule")
	private String schedule;
	
	@NotEmpty(message = "Ingrese el instructivo")
	@NotNull
	@Column(name="file")
	private String file;
	
	@NotEmpty(message = "Seleccione el status")
	@NotNull
	@Column(name="status")
	private Boolean status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_instructive")
	 private Instructive instructive;

}
