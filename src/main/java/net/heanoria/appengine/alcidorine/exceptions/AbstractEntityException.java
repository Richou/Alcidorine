package net.heanoria.appengine.alcidorine.exceptions;

public abstract class AbstractEntityException extends RuntimeException{

	private static final long serialVersionUID = 102281065349205842L;
	
	protected AbstractEntityException() {
		super();
	}
	
	protected AbstractEntityException(String message) {
		super(message);
	}
	
}
