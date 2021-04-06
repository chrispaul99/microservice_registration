package com.microservice.administrator.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.common.entities.models.Schedule;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "schedules")
@Entity
public class ScheduleData extends Schedule {
    @Id
	@Column(name="id_shedule")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSchedule;

	@OneToOne(cascade = CascadeType.ALL)		
	@JoinColumn(name = "fk_period", referencedColumnName = "id_period")
	@JsonIgnoreProperties(value = {"schedulesData"}, allowSetters = true)
	private PeriodData period;

	public ScheduleData() {
	}

	public ScheduleData(Long idSchedule) {
		this.idSchedule = idSchedule;
	}

	public Long getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(Long idSchedule) {
		this.idSchedule = idSchedule;
	}

	public PeriodData getPeriod() {
		return period;
	}

	public void setPeriod(PeriodData period) {
		this.period = period;
	}

	
    
}
