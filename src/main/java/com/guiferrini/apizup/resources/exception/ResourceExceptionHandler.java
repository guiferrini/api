package com.guiferrini.apizup.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.guiferrini.apizup.services.exception.ObjectNotFoundException;

@ControllerAdvice // Trata possíveis erros nas requisições
public class ResourceExceptionHandler {
	 
	@ExceptionHandler(ObjectNotFoundException.class) //padrao do framework, qdo ocorrer esta exceção, fazer este tratamento 
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException excp, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não Encontrado", excp.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
