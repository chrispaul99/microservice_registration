package com.microservice.administrator.models;

import java.util.ArrayList;
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
import javax.validation.constraints.Null;

import com.common.entities.models.Period;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "Periods")
@Entity
public class PeriodData extends Period {


	@OneToOne(cascade = CascadeType.REMOVE)		
	@JoinColumn(name = "fk_instructive", referencedColumnName = "id_instructive")
	private InstructiveData instructive;
	
	@OneToOne(cascade = CascadeType.ALL)		
	@JoinColumn(name = "fk_administrator", referencedColumnName = "id_administrator")
	private AdministradorData administrator;

	@OneToOne(cascade = CascadeType.ALL)		
	@JoinColumn(name = "fk_schedule", referencedColumnName = "id_schedule")
	private ScheduleData schedule;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "period", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = {"period"}, allowSetters = true)
	private List<PeriodSubject> periods_subject;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "period", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = {"period"}, allowSetters = true)
	private List<PeriodRegistration> periods_registration;

	public PeriodData() {
		this.periods_subject=new ArrayList<PeriodSubject>();
	}

	public InstructiveData getInstructive() {
		return instructive;
	}

	public void setInstructive(InstructiveData instructive) {
		this.instructive = instructive;
	}

	public AdministradorData getAdministrator() {
		return administrator;
	}

	public void setAdministrator(AdministradorData administrator) {
		this.administrator = administrator;
	}

	public ScheduleData getSchedule() {
		return schedule;
	}

	public void setSchedule(ScheduleData schedule) {
		this.schedule = schedule;
	}

	public List<PeriodSubject> getPeriods_subject() {
		return periods_subject;
	}

	public void setPeriods_subject(List<PeriodSubject> periods_subject) {
		this.periods_subject = periods_subject;
	}
	
	public void addSubject(PeriodSubject regis) {
		this.periods_subject.add(regis);
	}
	
	public void removeSubject(PeriodSubject regis) {
		this.periods_subject.remove(regis);
	}
	
}
