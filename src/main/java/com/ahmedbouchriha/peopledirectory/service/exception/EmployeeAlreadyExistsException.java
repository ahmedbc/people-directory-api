package com.ahmedbouchriha.peopledirectory.service.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeAlreadyExistsException(final String message) {
        super(message);
    }
}
