package com.microservice.administrator.exceptions;

import java.util.Set;

public class AdministratorUnSupportedFieldPatchException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AdministratorUnSupportedFieldPatchException(Set<String> keys)
	{
		super("Campo " + keys.toString() + " no es permitida la modificación.");
	}
}
