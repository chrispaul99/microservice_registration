package com.microservice.administrator.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.common.entities.models.Administrator;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "Administrators")
@Entity
public class AdministradorData extends Administrator{

    @Id
	@Column(name="id_administrator")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAdministrator;

	@OneToOne(mappedBy = "administrator", cascade = CascadeType.ALL)
	@JsonIgnore()
    private PeriodData period;

	public AdministradorData() {
	}

	public AdministradorData(Long idAdministrator) {
		this.idAdministrator = idAdministrator;
	}

	public Long getIdAdministrator() {
		return idAdministrator;
	}

	public void setIdAdministrator(Long idAdministrator) {
		this.idAdministrator = idAdministrator;
	}

	public PeriodData getPeriod() {
		return period;
	}

	public void setPeriod(PeriodData period) {
		this.period = period;
	}
	
	
}
