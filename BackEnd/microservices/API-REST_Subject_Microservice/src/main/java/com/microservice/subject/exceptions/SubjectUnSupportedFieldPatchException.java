package com.microservice.subject.exceptions;

import java.util.Set;

public class SubjectUnSupportedFieldPatchException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SubjectUnSupportedFieldPatchException(Set<String> keys)
	{
		super("Campo " + keys.toString() + " no es permitida la modificación.");
	}
}
