package com.cg.hsm.exception;

public class PatientCaseNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public PatientCaseNotFoundException() {
		super();
	}
	public PatientCaseNotFoundException(String err) {
		super(err);
	}

}