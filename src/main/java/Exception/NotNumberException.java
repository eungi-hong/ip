package Exception;

public class NotNumberException extends BeeException {
    public NotNumberException() {
        super("Please enter a number");
    }
}
