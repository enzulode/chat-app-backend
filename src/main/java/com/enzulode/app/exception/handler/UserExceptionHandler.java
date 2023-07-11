package com.enzulode.app.controller.advice;

import com.enzulode.app.dto.user.UserCreationStatusDTO;
import com.enzulode.app.dto.user.UserNotFoundDTO;
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
	@ExceptionHandler(value = {FailedToCreateUserException.class, UserNotFoundException.class})
	protected ResponseEntity<Object> handleUserCreationConflict(RuntimeException ex, WebRequest request)
	{
		if (ex.getClass().equals(UserNotFoundException.class))
			return handleExceptionInternal(
					ex,
					new UserNotFoundDTO("Failed to retrieve a user"),
					new HttpHeaders(),
					HttpStatus.CONFLICT,
					request
			);

		var responseMessage = "Failed to create new user";
		if (ex.getClass().equals(FailedToCreateUserException.class))
			return handleExceptionInternal(
					ex,
					new UserCreationStatusDTO(false, responseMessage),
					new HttpHeaders(),
					HttpStatus.CONFLICT,
					request
			);

		return handleExceptionInternal(
					ex,
					"Unexpected error",
					new HttpHeaders(),
					HttpStatus.CONFLICT,
					request
		);
	}
}
