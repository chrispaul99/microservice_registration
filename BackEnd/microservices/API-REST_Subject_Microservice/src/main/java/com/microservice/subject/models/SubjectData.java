package com.microservice.subject.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.common.entities.models.Subject;

@Table(name = "Subjects")
@Entity
public class SubjectData extends Subject {

	@OneToOne(mappedBy = "subject", cascade = CascadeType.REMOVE)
    private SubjectRegistration registration;
	
	public SubjectData() {
	}

	public SubjectRegistration getRegistration() {
		return registration;
	}

	public void setRegistration(SubjectRegistration registration) {
		this.registration = registration;
	}

	
	
	

	

	

	

	
    
}
