package com.microservice.administrator.exceptions;

import java.util.Set;

public class ScheduleUnSupportedFieldPatchException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ScheduleUnSupportedFieldPatchException(Set<String> keys)
	{
		super("Campo " + keys.toString() + " no es permitida la modificación.");
	}
}
