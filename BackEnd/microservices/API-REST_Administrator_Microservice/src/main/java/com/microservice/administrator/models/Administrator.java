package com.microservice.administrator.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(name = "Administrators")
@Entity
public class Administrator extends Person {
	
	@Id
	@Column(name="id_administrator")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAdministrator;

	@OneToOne(mappedBy = "administrator", cascade = CascadeType.ALL)
    private Period period;
	

	public Administrator(Long idAdministrator) {
		super();
		this.idAdministrator = idAdministrator;
	}

	public Administrator() {
		super();
	}

	public Long getIdAdministrator() {
		return idAdministrator;
	}

	public void setIdAdministrator(Long idAdministrator) {
		this.idAdministrator = idAdministrator;
	}

	
}
