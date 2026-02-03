package Exception;

public class NoTimeFrameException extends BeeException {
    public NoTimeFrameException() {
        super("An event needs a time frame!");
    }
}
