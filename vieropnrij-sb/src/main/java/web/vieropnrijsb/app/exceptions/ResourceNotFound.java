package web.vieropnrijsb.app.exceptions;

public class ResourceNotFound extends RuntimeException{
    private String message;

    public ResourceNotFound() {}

    public ResourceNotFound(String msg)
    {
        super(msg);
        this.message = msg;
    }
}

