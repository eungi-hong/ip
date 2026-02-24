package bee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeParseException;

import bee.Exception.BeeException;

public class Bee {
    private Storage storage;
    private TaskList tasks = new TaskList();

    /**
     * Initializes Bee by loading tasks from file. If file is missing or corrupted, an empty task list will be created.
     */
    public Bee() {
        storage = new Storage();
        try {
            tasks = storage.load();
        } catch (IndexOutOfBoundsException | DateTimeParseException | IOException e) {
            assert false : "file is missing or corrupted!";
        }
    }

    /**
     * Starts the program and prints a greeting message.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello!");
    }

    /**
     * Generates response to user input. If input is "bye", program will exit. Otherwise, the input will be processed and an appropriate response will be generated. If the input is invalid, an error message will be returned.
     * @param input
     * @return
     */
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
