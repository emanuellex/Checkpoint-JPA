package br.com.fiap.checkpoint.exception;

public class ItensNotFoundException extends Exception{
	
	public ItensNotFoundException() {
		super("não encontrado");
	}
	
	public ItensNotFoundException(String msg) {
		super(msg);		
	}

}
