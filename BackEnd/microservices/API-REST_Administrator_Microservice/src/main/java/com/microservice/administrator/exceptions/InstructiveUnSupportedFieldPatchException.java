package com.microservice.administrator.exceptions;

import java.util.Set;

public class InstructiveUnSupportedFieldPatchException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InstructiveUnSupportedFieldPatchException(Set<String> keys)
	{
		super("Campo " + keys.toString() + " no es permitida la modificación.");
	}
}
