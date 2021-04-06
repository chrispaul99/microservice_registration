package com.microservice.administrator.models;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "Instrutives")
@Entity
public class Instructive {
	@Id
	@Column(name="id_instructive")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idInstructive;
	@NotEmpty(message = "Ingrese el instructivo")
	@NotNull
	@Column(name="document")
	private String document;
	
	@NotNull
	@Column(name="status")
	private Boolean status;

	@JsonIgnore
	@OneToOne(mappedBy = "instructive", cascade = CascadeType.ALL)
    private Period period;
	
	

	public Instructive(Long idInstructive) {
		super();
		this.idInstructive = idInstructive;
	}

	public Instructive() {
		super();
	}

	public Long getIdInstructive() {
		return idInstructive;
	}

	public void setIdInstructive(Long idInstructive) {
		this.idInstructive = idInstructive;
	}

	public String getDocument() {
		return document;
	}

	public void setFile(String document) {
		this.document = document;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

}
