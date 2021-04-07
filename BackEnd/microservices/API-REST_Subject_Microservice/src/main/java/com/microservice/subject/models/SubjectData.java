package com.microservice.subject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.common.entities.models.Subject;

@Table(name = "Subjects")
@Entity
public class SubjectData extends Subject {

	public SubjectData() {
	}

	
    
}
