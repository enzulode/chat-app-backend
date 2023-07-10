package com.enzulode.app.exception;

public class FailedToCreateUserException extends RuntimeException
{
	public FailedToCreateUserException(String message)
	{
		super(message);
	}

	public FailedToCreateUserException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
