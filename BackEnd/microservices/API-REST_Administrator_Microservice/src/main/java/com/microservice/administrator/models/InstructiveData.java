package com.microservice.administrator.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.common.entities.models.Instructive;

@Table(name = "Instrutives")
@Entity
public class InstructiveData extends Instructive {
    @Id
	@Column(name="id_instructive")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idInstructive;

	@OneToOne(mappedBy = "instructive", cascade = CascadeType.ALL)
    private PeriodData period;

	public InstructiveData() {
	}

	public InstructiveData(Long idInstructive) {
		this.idInstructive = idInstructive;
	}

	public Long getIdInstructive() {
		return idInstructive;
	}

	public void setIdInstructive(Long idInstructive) {
		this.idInstructive = idInstructive;
	}

	public PeriodData getPeriod() {
		return period;
	}

	public void setPeriod(PeriodData period) {
		this.period = period;
	}
	

	
}
