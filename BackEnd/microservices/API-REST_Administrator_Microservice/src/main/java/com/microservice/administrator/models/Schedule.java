package com.microservice.administrator.models;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "Schedules")
@Entity
public class Schedule {
    @Id
	@Column(name="id_shedule")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSchedule;

	@NotNull
	@Column(name="credit_min")
	private Integer credit_min;

	@NotNull
	@Column(name="credit_max")
	private Integer credit_max;

    @NotEmpty(message = "Ingrese el tipo de estudiante")
	@NotNull
	@Size(max = 1, message = "El tipo de estudiante debe ser Z,C o T")
	@Column(name="type")
	private String type;

    @Column(name="start_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Calendar date_from;

    @NotEmpty(message = "Ingrese la descripcion")
	@NotNull
	@Column(name="description")
	private String descripcion;

	@OneToOne(cascade = CascadeType.ALL)		
	@JoinColumn(name = "fk_period", referencedColumnName = "id_period")
	private Period period;

	public Schedule() {
	}

	public Schedule(Long idSchedule) {
		this.idSchedule = idSchedule;
	}

	public Long getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(Long idSchedule) {
		this.idSchedule = idSchedule;
	}

	public int getCredit_min() {
		return credit_min;
	}

	public void setCredit_min(int credit_min) {
		this.credit_min = credit_min;
	}

	public int getCredit_max() {
		return credit_max;
	}

	public void setCredit_max(int credit_max) {
		this.credit_max = credit_max;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Calendar getDate_from() {
		return date_from;
	}

	public void setDate_from(Calendar date_from) {
		this.date_from = date_from;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
	
	
}
