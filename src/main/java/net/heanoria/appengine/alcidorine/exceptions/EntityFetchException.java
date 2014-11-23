package net.heanoria.appengine.alcidorine.exceptions;

public class EntityFetchException extends AbstractEntityException{

	private static final long serialVersionUID = -8881527618731246839L;
	
	public EntityFetchException() {
		super();
	}
	
	public EntityFetchException(String message) {
		super();
		this.message = message;
	}

}
