package com.ahmedbouchriha.peopledirectory.service.exception;

public class CompanyAlreadyExistsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompanyAlreadyExistsException(final String message) {
        super(message);
    }
}
