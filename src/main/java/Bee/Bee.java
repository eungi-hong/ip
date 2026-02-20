package Bee;

import Bee.Exception.BeeException;
import java.io.FileNotFoundException;
import java.time.format.DateTimeParseException;

public class Bee {
    private Storage storage;
    private Ui ui;
    private TaskList tasks;

    /**
     * Initializes Bee object with default UI, storage classes, and task list loaded from storage.
     * @param filePath
     */
    public Bee(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = storage.load();
        } catch (FileNotFoundException | IndexOutOfBoundsException | DateTimeParseException e) {
            ui.output(e.getMessage());
            tasks = new TaskList();
        }
    }

    /**
     * Entry point
     * @param args
     */
    public static void main(String[] args) {
        new Bee("src/main/java/Bee/data/tasks.txt").run();
    }

    /**
     * Runs chatbot Bee
     * This method repeatedly reads input with UI, and leverages handler class to handle most queries
     */
    public void run() {
        ui.output("Hello! I'm Bee");
        ui.output("What can I do for you?");
        String input = ui.nextLine();

        while (true) {
            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                return;
            } else {
                try {
                    Handler.handle(input, ui, storage, tasks);
                } catch (BeeException e) {
                    System.out.println(e.getMessage());
                }
            }
            input = ui.nextLine();
        }
    }
}
