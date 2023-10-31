package com.example.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class ServiceNotAvailableException extends Exception{
	
	public ServiceNotAvailableException(String msg)
	{
		super(msg);
	}

}
