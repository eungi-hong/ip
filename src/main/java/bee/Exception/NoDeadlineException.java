package bee.Exception;

public class NoDeadlineException extends BeeException {
    public NoDeadlineException() {
        super("A deadline task... needs a deadline! Duh!");
    }
}
