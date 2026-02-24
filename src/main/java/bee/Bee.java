package bee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeParseException;

import bee.Exception.BeeException;

public class Bee {
    private Storage storage;
    private TaskList tasks = new TaskList();

    public Bee() {
        storage = new Storage();
        try {
            tasks = storage.load();
        } catch (IndexOutOfBoundsException | DateTimeParseException | IOException e) {
            assert false : "file is missing or corrupted!";
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello!");
    }

    public String getResponse(String input) {
        if (input.equals("bye")) {
            return "bye!";
        }
        try {
            return Handler.handle(input, storage, tasks);
        } catch (BeeException e) {
            return (e.getMessage());
        }
    }
}
