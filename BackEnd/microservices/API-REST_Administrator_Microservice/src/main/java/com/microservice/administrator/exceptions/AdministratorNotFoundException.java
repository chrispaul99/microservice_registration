package com.microservice.administrator.exceptions;

public class AdministratorNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AdministratorNotFoundException(Long id)
	{
		super("Estudiente no se encuentra : " + id);
	}
}
