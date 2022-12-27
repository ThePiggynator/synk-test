package web.vieropnrijsb.app.exceptions;

public class BadRequest extends RuntimeException{
    private String message;
    public BadRequest() {}

    public BadRequest(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
