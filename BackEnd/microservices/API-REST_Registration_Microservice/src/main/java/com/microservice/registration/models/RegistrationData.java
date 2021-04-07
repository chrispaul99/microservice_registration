package com.microservice.registration.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.common.entities.models.Registration;

@Table(name = "Registrations")
@Entity
public class RegistrationData extends Registration{
    public RegistrationData() {
    }
    
}

