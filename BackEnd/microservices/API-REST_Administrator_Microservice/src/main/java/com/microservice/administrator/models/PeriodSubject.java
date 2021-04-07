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
@Table(name = "periods_subjects")
public class PeriodSubject {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "id_subject", unique = true)
	private Long idSubject;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_period",referencedColumnName="id_period")
	@JsonIgnoreProperties(value = {"periodsSubjects"})
	private PeriodData period;
}
