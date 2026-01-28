public class EmptyTaskException extends BeeException {
    public EmptyTaskException() {
        super("A task needs a name... :(");
    }
}
