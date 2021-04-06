package com.microservice.registration.exceptions;

public class RegistrationNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RegistrationNotFoundException(Long id)
	{
		super("Estudiente no se encuentra : " + id);
	}
}
