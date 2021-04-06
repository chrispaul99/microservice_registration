package com.common.entities.models;

import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "Periods")
@Entity
public class Period {
	@Id
	@Column(name="id_period")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPeriod;
	
	@Column(name="start_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Calendar start_date;
	
	@Column(name="end_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Calendar end_date;
		
	@NotNull
	@Column(name="status")
	private Boolean status;

	@OneToOne(cascade = CascadeType.ALL)		
	@JoinColumn(name = "fk_instructive", referencedColumnName = "id_instructive")
	private Instructive instructive;

	@OneToOne(mappedBy = "period", cascade = CascadeType.ALL)
    private Schedule schedule;
	
	@OneToOne(cascade = CascadeType.ALL)		
	@JoinColumn(name = "fk_administrator", referencedColumnName = "id_administrator")
	private Administrator administrator;

	@OneToMany(mappedBy="period",fetch=FetchType.LAZY)
		private List<Subject> subjects; 

	@OneToOne(mappedBy = "period", cascade = CascadeType.ALL)
	private Registration registration;

	public Period() {
	}

	public Period(Long idPeriod) {
		this.idPeriod = idPeriod;
	}
	
	public Long getIdPeriod() {
		return idPeriod;
	}

	public void setIdPeriod(Long idPeriod) {
		this.idPeriod = idPeriod;
	}
	
	public Calendar getStart_date() {
		return start_date;
	}

	public void setStart_date(Calendar start_date) {
		this.start_date = start_date;
	}

	public Calendar getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Calendar end_date) {
		this.end_date = end_date;
	}


	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Instructive getInstructive() {
		return instructive;
	}

	public void setInstructive(Instructive instructive) {
		this.instructive = instructive;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	

}
