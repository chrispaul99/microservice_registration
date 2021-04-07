package com.security.server.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.common.entities.models.User;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class UserData extends User {
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<RoleData> roles = new HashSet<>();
    public Set<RoleData> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleData> roles) {
		this.roles = roles;
	}

    public UserData() {
    }
}
