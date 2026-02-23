package bee;

import java.io.FileNotFoundException;
import java.time.format.DateTimeParseException;

import bee.Exception.BeeException;

public class Bee {
    private Storage storage;
    private TaskList tasks;
    private String filePath = "src/main/java/Bee/data/tasks.txt";

    public Bee() {
        storage = new Storage(filePath);
        try {
            tasks = storage.load();
        } catch (FileNotFoundException | IndexOutOfBoundsException | DateTimeParseException e) {
            assert false : "data file corrupted or does not exist";
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
