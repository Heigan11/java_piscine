package exceptions;

public class GameOverException extends RuntimeException {
    public GameOverException(String msg){
        super(msg);
    }
}