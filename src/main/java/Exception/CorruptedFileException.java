package Exception;

public class CorruptedFileException extends BeeException {
    public CorruptedFileException() {
        super("Seems like someone messed with your task file... ");
    }
}
