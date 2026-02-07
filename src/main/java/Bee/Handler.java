package Bee;

import Bee.Exception.*;
import java.io.IOException;


public class Handler {
    public static void handle(String input, Ui ui, Storage storage, TaskList tasks) throws BeeException {
        if (input.equals("list")) {
            ui.output("Here are the tasks in your list:");
            ui.output(tasks.toString());
        }
        else if (input.startsWith("mark")) {
            try {
                Integer ind = Parser.validateIntInRange(input.split(" ")[1], 1, tasks.getLength());
                tasks.doTask(ind);
                storage.updateFile(tasks);
                ui.output("Nice! I've marked this task as done:");
                ui.output(tasks.getTask(ind).toString());
            } catch (NotNumberException | IndexException | IOException err) {
                ui.output(err.toString());
            }
        }
        else if (input.startsWith("unmark")) {
            try {
                Integer ind = Parser.validateIntInRange(input.split(" ")[1], 1, tasks.getLength());
                tasks.undoTask(ind);
                storage.updateFile(tasks);
                ui.output("Nice! I've marked this task as done:");
                ui.output(tasks.getTask(ind).toString());
            } catch (NotNumberException | IndexException | IOException err) {
                ui.output(err.toString());
            }
        }
        else if (input.startsWith("todo")) {
            try {
                Todo t = Parser.validateTodo(input);
                tasks.addTodo(t);
                storage.updateFile(tasks);
                ui.output("Got it. I've added this task:");
                ui.output(tasks.lastTask().toString());
                ui.output("Now you have " + tasks.getLength() + " tasks in the list.");
            } catch (EmptyTaskException | IOException err) {
                ui.output(err.toString());
            }
        }
        else if (input.startsWith("deadline")) {
            try {
                Deadline d = Parser.validateDeadline(input);
                tasks.addDeadline(d);
                storage.updateFile(tasks);
                ui.output("Got it. I've added this task:");
                ui.output(tasks.lastTask().toString());
                ui.output("Now you have " + tasks.getLength() + " tasks in the list.");
            } catch (EmptyTaskException | IOException err) {
                ui.output(err.toString());
            }
        }
        else if (input.startsWith("event")) {
            try {
                Event e = Parser.validateEvent(input);
                tasks.addEvent(e);
                storage.updateFile(tasks);
                ui.output("Got it. I've added this task:");
                ui.output(tasks.lastTask().toString());
                ui.output("Now you have " + tasks.getLength() + " tasks in the list.");
            } catch (EmptyTaskException | IOException err) {
                ui.output(err.toString());
            }
        }
        else if (input.startsWith("delete")) {
            try {
                Integer ind = Parser.validateIntInRange(input.split(" ")[1], 1, tasks.getLength());
                Task task = tasks.getTask(ind);
                tasks.deleteTask(ind);
                storage.updateFile(tasks);
                ui.output("Noted. I've removed this task:");
                ui.output(task.toString());
                ui.output("Now you have " + tasks.getLength() + " tasks in the list.");
            } catch (NotNumberException | IndexException | IOException err) {
                ui.output(err.toString());
            }
        }
        else {
            throw new UnknownCommandException();
        }
    }
}
