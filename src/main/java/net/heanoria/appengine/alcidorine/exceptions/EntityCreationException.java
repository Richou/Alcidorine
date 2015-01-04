package net.heanoria.appengine.alcidorine.exceptions;

public class EntityCreationException extends AbstractEntityException{

    private static final long serialVersionUID = -3122601635798416108L;

    public EntityCreationException() {
        super();
    }
    
    public EntityCreationException(String message) {
        super(message);
    }

}
