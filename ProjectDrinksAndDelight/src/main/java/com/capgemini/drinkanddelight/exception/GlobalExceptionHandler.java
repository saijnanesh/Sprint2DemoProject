package com.capgemini.drinkanddelight.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.capgemini.drinkanddelight.entity.CustomExceptionEntity;

@RestControllerAdvice
/*
 * ControllerAdvice + ResponseBody ==> RestControllerAdvice
 */
public class GlobalExceptionHandler {

	//ProductOrderEntityNotFoundException
	@ExceptionHandler(value=ProductOrderEntityNotFoundException.class)
	public ResponseEntity<Object> productorderentityexception(ProductOrderEntityNotFoundException obj,WebRequest req){
		
		CustomExceptionEntity err = new CustomExceptionEntity(new Date(),obj.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	//DistributorNotFoundException
		@ExceptionHandler(value=DistributorNotFoundException.class)
		public ResponseEntity<Object> productorderentityexception(DistributorNotFoundException obj,WebRequest req){
			
			CustomExceptionEntity err = new CustomExceptionEntity(new Date(),obj.getMessage(),req.getDescription(false));
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	
	
}
