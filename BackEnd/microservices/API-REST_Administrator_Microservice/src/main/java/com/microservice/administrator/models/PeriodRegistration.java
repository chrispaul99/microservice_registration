package com.microservice.administrator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "periods_registrations")
public class PeriodRegistration {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "id_registration", unique = true)
	private Long idRegistration;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_period",referencedColumnName="id_period")
	@JsonIgnoreProperties(value = {"periodsRegistrations"})
	private PeriodData period;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(Long idRegistration) {
        this.idRegistration = idRegistration;
    }

    public PeriodData getPeriod() {
        return period;
    }

    public void setPeriod(PeriodData period) {
        this.period = period;
    }

    

    
    
}
