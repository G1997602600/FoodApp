package com.ty.foodappapi.exceptioncontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ty.foodappapi.dao.ResponceStructure;

@ControllerAdvice
public class IdNotFoundExceptionHandeler {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponceStructure<String>> IdNotFoundExceptionHandeler(IdNotFoundException e) {
		ResponceStructure<String> r = new ResponceStructure<String>();
		r.setResponcecode(HttpStatus.NOT_FOUND.value());
		r.setMessage("FAILED");
		r.setDate(e.message);
		return new ResponseEntity<ResponceStructure<String>>(r, HttpStatus.OK);

	}

}
