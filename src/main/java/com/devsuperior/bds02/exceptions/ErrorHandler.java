package com.devsuperior.bds02.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler
	public ResponseEntity<StandardError> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
		StandardError error = new StandardError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(Instant.now());
		error.setError("Resource not found!");
		error.setPath(request.getRequestURI());		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler()
	public ResponseEntity<StandardError> databaseIntegrityDependentId (DatabaseIntegrityDependentId e, HttpServletRequest request) {
		StandardError error = new StandardError();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(Instant.now());
		error.setError("Integrity violation!");
		error.setPath(request.getRequestURI());		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
