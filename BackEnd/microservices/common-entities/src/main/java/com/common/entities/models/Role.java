package com.common.entities.models;
import javax.persistence.*;

@MappedSuperclass
public abstract class Role {

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
}