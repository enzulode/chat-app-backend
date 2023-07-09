package com.enzulode.app.controller.advice;

import com.enzulode.app.dto.user.UserCreationStatusDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(value = {DataIntegrityViolationException.class})
	protected ResponseEntity<Object> handleUserCreationConflict(RuntimeException ex, WebRequest request)
	{
		var responseMessage = "Failed to create new user: data integrity constraint violated";
		return handleExceptionInternal(
				ex,
				new UserCreationStatusDTO(false, responseMessage),
				new HttpHeaders(),
				HttpStatus.CONFLICT,
				request
		);
	}
}
