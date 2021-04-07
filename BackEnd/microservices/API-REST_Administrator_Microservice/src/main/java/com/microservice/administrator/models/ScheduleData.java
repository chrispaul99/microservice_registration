package com.microservice.administrator.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.common.entities.models.Schedule;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "schedules")
@Entity
public class ScheduleData extends Schedule {
    @Id
	@Column(name="id_schedule")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSchedule;

	@OneToOne(mappedBy ="schedule", cascade = CascadeType.REMOVE)
	@JsonIgnore()
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
