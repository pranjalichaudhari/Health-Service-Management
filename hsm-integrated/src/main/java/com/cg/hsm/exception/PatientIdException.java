package com.cg.hsm.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PatientIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientIdException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientIdException(String errMsg) {
		super(errMsg);
		// TODO Auto-generated constructor stub
	}

	
	

}