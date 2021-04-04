package com.microservice.administrator.exceptions;

public class PeriodNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PeriodNotFoundException(Long id)
	{
		super("Estudiente no se encuentra : " + id);
	}
}
