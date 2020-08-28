package com.guiferrini.apizup.services.exception;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	//Sobrepor construtor basico, recebendo String mensagem como argumento
	public ObjectNotFoundException(String msg) {
		super(msg); //repassa a chamada p superclass RuntimeException
	}
}
