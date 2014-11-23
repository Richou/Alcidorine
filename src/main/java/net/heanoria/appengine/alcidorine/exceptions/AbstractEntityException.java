package net.heanoria.appengine.alcidorine.exceptions;

public abstract class AbstractEntityException extends RuntimeException{

	private static final long serialVersionUID = 102281065349205842L;
	
	protected String message = null;
	
	@Override
	public String getMessage() {
		return message;
	}

}
