package com.microservice.administrator.exceptions;

public class InstructiveNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InstructiveNotFoundException(Long id)
	{
		super("Estudiente no se encuentra : " + id);
	}
}
