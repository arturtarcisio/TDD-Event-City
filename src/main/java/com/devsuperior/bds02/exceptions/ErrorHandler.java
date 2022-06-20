package com.devsuperior.bds02.exceptions;

import java.time.Instant;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<StandardError> resourceNotFoundException(EmptyResultDataAccessException e, HttpServletRequest request) {
		StandardError error = new StandardError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(Instant.now());
		error.setError("Resource not found!");
		error.setPath(request.getRequestURI());		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> databaseIntegrityDependentId (DataIntegrityViolationException e, HttpServletRequest request) {
		StandardError error = new StandardError();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("ID is foreign key in other table" );
		error.setTimestamp(Instant.now());
		error.setError("Integrity violation!");
		error.setPath(request.getRequestURI());		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<StandardError> noSuchElementException (NoSuchElementException e, HttpServletRequest request) {
		StandardError error = new StandardError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(Instant.now());
		error.setError("Resource not found!");
		error.setPath(request.getRequestURI());		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
