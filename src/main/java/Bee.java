import Exception.BeeException;
import java.io.FileNotFoundException;
import java.time.format.DateTimeParseException;

public class Bee {
    private Storage storage;
    private Ui ui;
    private TaskList tasks;

    public Bee(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = storage.load();
        } catch (FileNotFoundException | IndexOutOfBoundsException | DateTimeParseException e) {
            ui.output("task file corrupted!");
            tasks = new TaskList();
        }
    }

    public static void main(String[] args) {
        new Bee("src/main/java/data/tasks.txt").run();
    }

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
