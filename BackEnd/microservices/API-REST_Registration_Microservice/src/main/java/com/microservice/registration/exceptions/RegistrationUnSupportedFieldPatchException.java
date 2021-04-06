package com.microservice.registration.exceptions;

import java.util.Set;

public class RegistrationUnSupportedFieldPatchException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RegistrationUnSupportedFieldPatchException(Set<String> keys)
	{
		super("Campo " + keys.toString() + " no es permitida la modificación.");
	}
}
