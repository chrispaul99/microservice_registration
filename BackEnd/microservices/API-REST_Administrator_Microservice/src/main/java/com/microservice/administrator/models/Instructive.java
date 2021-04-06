package com.microservice.administrator.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "Instrutives")
@Entity
public class Instructive {
	@Id
	@Column(name="id_instructive")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idInstructive;
	@NotEmpty(message = "Ingrese el instructivo")
	@NotNull
	@Column(name="file")
	private String file;
	
	@NotNull
	@Column(name="status")
	private Boolean status;
	

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

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
