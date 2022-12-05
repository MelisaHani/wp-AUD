package mk.ukim.finki.wpaud.model.exceptions;

public class PasswordDoNotMatchException extends RuntimeException{
    public PasswordDoNotMatchException(){
        super("Password Do NotMatch");
    }
}
