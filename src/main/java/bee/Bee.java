package bee;

import java.io.FileNotFoundException;
import java.time.format.DateTimeParseException;

import bee.Exception.BeeException;

public class Bee {
    private Storage storage;
    private Ui ui;
    private TaskList tasks;
    private String filePath = "src/main/java/Bee/data/tasks.txt";

    public Bee() {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = storage.load();
        } catch (FileNotFoundException | IndexOutOfBoundsException | DateTimeParseException e) {
            ui.output(e.getMessage());
            tasks = new TaskList();
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello!");
    }

    public String getResponse(String input) {
        if (input.equals("bye")) {
            return "bye!";
        } else {
            try {
                String response = Handler.handle(input, ui, storage, tasks);
                return response;
            } catch (BeeException e) {
                return (e.getMessage());
            }
        }
    }
}
