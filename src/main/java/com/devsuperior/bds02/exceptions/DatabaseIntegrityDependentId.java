package com.devsuperior.bds02.exceptions;

public class DatabaseIntegrityDependentId extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public DatabaseIntegrityDependentId (String msg) {
		super(msg);
	}
	
}
