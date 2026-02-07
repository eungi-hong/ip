package Exception;

public class NotDateTimeException extends BeeException{
    public NotDateTimeException() {
        super("Date & Time gotta be in 2020-01-01 format!!");
    }
}
