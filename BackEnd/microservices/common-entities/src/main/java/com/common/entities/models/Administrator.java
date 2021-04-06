package com.common.entities.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@OneToOne(cascade = CascadeType.ALL)		
	@JoinColumn(name = "fk_user", referencedColumnName = "id")
	private User user;

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

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	
}
