package Exception;

public class IndexException extends BeeException {
    public IndexException() {
        super("Task doesn't exit... please enter a valid task index!");
    }
}
