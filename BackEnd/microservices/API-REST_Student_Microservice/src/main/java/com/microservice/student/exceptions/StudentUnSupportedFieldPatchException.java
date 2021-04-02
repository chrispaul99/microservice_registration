package com.microservice.student.exceptions;

import java.util.Set;

public class StudentUnSupportedFieldPatchException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StudentUnSupportedFieldPatchException(Set<String> keys)
	{
		super("Campo " + keys.toString() + " no es permitida la modificación.");
	}
}
