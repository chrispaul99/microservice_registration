package com.microservice.administrator.exceptions;

public class ScheduleNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ScheduleNotFoundException(Long id)
	{
		super("Estudiente no se encuentra : " + id);
	}
}
