package com.app.advicecontroller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@SuppressWarnings("serial")
@ControllerAdvice
public class AccountNumberNotFoundException extends Exception{
	
	@ExceptionHandler(Exception.class)
	public String handleException() {
		return "genericError";
	}
	@ExceptionHandler(AccountNumberNotFoundException.class)
	public String invalidNumber() {
		return "AccountNotFound";
	}

}
