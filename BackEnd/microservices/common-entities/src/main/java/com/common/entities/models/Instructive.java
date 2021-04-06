package com.common.entities.models;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Instructive {
	
	@NotEmpty(message = "Ingrese el instructivo")
	@NotNull
	@Column(name="document")
	private String document;
	
	@NotNull
	@Column(name="status")
	private Boolean status;

	
	
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
	public void setDocument(String document) {
		this.document = document;
	}
}
