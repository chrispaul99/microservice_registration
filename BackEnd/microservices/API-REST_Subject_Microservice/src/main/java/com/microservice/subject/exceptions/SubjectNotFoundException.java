package com.microservice.subject.exceptions;

public class SubjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SubjectNotFoundException(Long id)
	{
		super("Estudiente no se encuentra : " + id);
	}
}
