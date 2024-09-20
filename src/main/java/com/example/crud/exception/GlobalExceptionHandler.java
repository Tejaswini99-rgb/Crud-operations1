package com.example.crud.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(EmployeeNotFoundException.class)
	    public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
	        ErrorResponse errorResponse = new ErrorResponse("Employee not found", HttpStatus.NOT_FOUND.value());
	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	    }
	
}