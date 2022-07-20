package exceptions;

public class GaveUpException extends RuntimeException {
    public GaveUpException(String msg){
        super(msg);
    }
}