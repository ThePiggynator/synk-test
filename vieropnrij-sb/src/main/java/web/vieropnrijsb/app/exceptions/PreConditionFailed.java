package web.vieropnrijsb.app.exceptions;

public class PreConditionFailed extends RuntimeException{
    private String message;
    public PreConditionFailed() {}

    public PreConditionFailed(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
