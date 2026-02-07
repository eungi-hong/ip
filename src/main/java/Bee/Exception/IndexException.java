package Bee.Exception;

public class IndexException extends BeeException {
    public IndexException() {
        super("Bee.Task doesn't exit... please enter a valid task index!");
    }
}
