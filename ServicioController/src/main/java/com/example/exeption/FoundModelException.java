package com.example.exeption;

public class FoundModelException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	public FoundModelException(String mensaje) {
        super(mensaje);
    }

}
