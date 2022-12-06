package com.futebol.times.times_e_jogadores.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1671172735404253894L;

	public BadRequestException(String message) {
		super(message);
	}

}
