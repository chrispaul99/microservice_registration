package com.security.server.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.common.entities.models.Role;

@Entity
@Table(name = "roles")
public class RoleData extends Role {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
}
