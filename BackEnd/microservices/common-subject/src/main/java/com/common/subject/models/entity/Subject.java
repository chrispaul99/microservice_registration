package com.common.subject.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "Subjects")
@Entity
public class Subject {
    @Id
	@Column(name="id_subject")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSubject;

	@NotEmpty(message = "Ingrese el nombre de la materia")
	@NotNull
	@Size(min = 2, message = "La materia tener al menos 2 caracteres")
	@Column(name="name")
	private String name;

	@NotEmpty(message = "Ingrese la carrera asignada")
	@NotNull
	@Size(min = 2, message = "La carrera asignada debe tener al menos 2 caracteres")
	@Column(name="assigned_career")
	private String assigned_career;
	
	@NotNull
	@Column(name="level")
	private Integer level;

    @NotEmpty(message = "Ingrese el NRC de la materia")
	@NotNull
	@Size(min = 2, message = "La materia debe tener al menos 2 caracteres")
	@Column(name="nrc")
	private String nrc;

	@NotNull
	@Column(name="total_credits")
	private Integer total_credits;

    @NotNull
	@Column(name="status")
	private Boolean status;

    public Subject() {
    }

    public Subject(Long idSubject) {
        this.idSubject = idSubject;
    }

    public Long getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Long idSubject) {
        this.idSubject = idSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssigned_career() {
        return assigned_career;
    }

    public void setAssigned_career(String assigned_career) {
        this.assigned_career = assigned_career;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public int getTotal_credits() {
        return total_credits;
    }

    public void setTotal_credits(int total_credits) {
        this.total_credits = total_credits;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
