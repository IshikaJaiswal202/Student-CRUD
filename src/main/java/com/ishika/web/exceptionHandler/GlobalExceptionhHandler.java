package com.ishika.web.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ishika.web.bean.ApiResponse;
import com.ishika.web.exceptions.ResourceNotFoundExceptions;

@RestControllerAdvice
public class GlobalExceptionhHandler {

	 @ExceptionHandler(ResourceNotFoundExceptions.class)
	 public ResponseEntity<ApiResponse> resourceNotFoundExceptions(ResourceNotFoundExceptions e)
	 {
		 ApiResponse response=ApiResponse.builder()
				 .msg(e.getMessage())
		 .status(HttpStatus.NOT_FOUND)
		 .success(true)
		 .build();
		 return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	 }
}
