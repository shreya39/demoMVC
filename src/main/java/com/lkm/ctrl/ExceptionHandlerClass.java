package com.lkm.ctrl;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerClass {

	
	@ExceptionHandler(value= javax.validation.ConstraintViolationException.class)
	public String nullpointerexception(Model m) {
		m.addAttribute("msg", "String cannot be empty");
		return "errorpage";
	}
	
	@ResponseStatus(value=HttpStatus.EXPECTATION_FAILED)
	@ExceptionHandler(value=Exception.class)
	public String genericException(Model m) {
		m.addAttribute("msg", "Exception Occurred");
		return "errorpage";
	}
}
