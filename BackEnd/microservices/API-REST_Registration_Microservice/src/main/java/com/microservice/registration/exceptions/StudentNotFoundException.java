package com.microservice.registration.exceptions;

public class StudentNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(Long id)
	{
		super("Estudiente no se encuentra : " + id);
	}
}
