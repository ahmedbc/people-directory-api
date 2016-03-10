package com.ahmedbouchriha.peopledirectory.service.exception;

public class DepartmentAlreadyExistsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DepartmentAlreadyExistsException(final String message) {
        super(message);
    }
}
