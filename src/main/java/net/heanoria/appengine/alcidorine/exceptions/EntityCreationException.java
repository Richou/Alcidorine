package net.heanoria.appengine.alcidorine.exceptions;

public class EntityCreationException extends RuntimeException{

	private static final long serialVersionUID = -3122601635798416108L;
	
	private String message = null;
	
	public EntityCreationException() {
		super();
	};
	
	public EntityCreationException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
