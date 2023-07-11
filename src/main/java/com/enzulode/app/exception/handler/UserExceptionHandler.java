package com.enzulode.app.exception.handler;

import com.enzulode.app.dto.user.UserOperationResultDTO;
import com.enzulode.app.exception.FailedToCreateUserException;
import com.enzulode.app.exception.UserNotFoundException;
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
	@ExceptionHandler(value = {FailedToCreateUserException.class})
	protected ResponseEntity<Object> handleUserCreationConflict(RuntimeException ex, WebRequest req)
	{
		return handleExceptionInternal(
				ex,
				new UserOperationResultDTO("Failed to create a new user"),
				new HttpHeaders(),
				HttpStatus.CONFLICT,
				req
		);
	}

	@ExceptionHandler(value = {UserNotFoundException.class})
	protected ResponseEntity<Object> handleUserRetrievingConflict(RuntimeException ex, WebRequest req)
	{
		return handleExceptionInternal(
				ex,
				new UserOperationResultDTO("Failed to retrieve a user"),
				new HttpHeaders(),
				HttpStatus.CONFLICT,
				req
		);
	}
}
