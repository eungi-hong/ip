package bee;

import bee.Exception.*;
import java.io.IOException;


public class Handler {
    /**
     * Outputs appropriate response to user input.
     * @param input
     * @param ui
     * @param storage
     * @param tasks
     * @throws BeeException
     */
    public static String handle(String input, Ui ui, Storage storage, TaskList tasks) throws BeeException {
        StringBuilder response = new StringBuilder();

        if (input.equals("list")) {
            response.append("Here are the tasks in your list:\n");
            response.append(tasks.toString());
        }
        else if (input.startsWith("mark")) {
            try {
                Integer ind = Parser.validateIntInRange(input.split(" ")[1], 1, tasks.getLength());
                tasks.doTask(ind);
                storage.updateFile(tasks);
                response.append("Nice! I've marked this task as done:\n");
                response.append(tasks.getTask(ind).toString());
            } catch (NotNumberException | IndexException | IOException err) {
                response.append(err.toString());
            }
        }
        else if (input.startsWith("unmark")) {
            try {
                Integer ind = Parser.validateIntInRange(input.split(" ")[1], 1, tasks.getLength());
                tasks.undoTask(ind);
                storage.updateFile(tasks);
                response.append("Nice! I've marked this task as done:\n");
                response.append(tasks.getTask(ind).toString());
            } catch (NotNumberException | IndexException | IOException err) {
                response.append(err.toString());
            }
        }
        else if (input.startsWith("todo")) {
            try {
                Todo t = Parser.validateTodo(input);
                tasks.addTodo(t);
                storage.updateFile(tasks);
                response.append("Got it. I've added this task:\n");
                response.append(tasks.lastTask().toString());
                response.append("\nNow you have " + tasks.getLength() + " tasks in the list.");
            } catch (EmptyTaskException | IOException err) {
                response.append(err.toString());
            }
        }
        else if (input.startsWith("deadline")) {
            try {
                Deadline d = Parser.validateDeadline(input);
                tasks.addDeadline(d);
                storage.updateFile(tasks);
                response.append("Got it. I've added this task:\n");
                response.append(tasks.lastTask().toString());
                response.append("\nNow you have " + tasks.getLength() + " tasks in the list.");
            } catch (EmptyTaskException | IOException err) {
                response.append(err.toString());
            }
        }
        else if (input.startsWith("event")) {
            try {
                Event e = Parser.validateEvent(input);
                tasks.addEvent(e);
                storage.updateFile(tasks);
                response.append("Got it. I've added this task:\n");
                response.append(tasks.lastTask().toString());
                response.append("\nNow you have " + tasks.getLength() + " tasks in the list.");
            } catch (EmptyTaskException | IOException err) {
                response.append(err.toString());
            }
        }
        else if (input.startsWith("delete")) {
            try {
                Integer ind = Parser.validateIntInRange(input.split(" ")[1], 1, tasks.getLength());
                Task task = tasks.getTask(ind);
                tasks.deleteTask(ind);
                storage.updateFile(tasks);
                response.append("Noted. I've removed this task:\n");
                response.append(task.toString());
                response.append("\nNow you have " + tasks.getLength() + " tasks in the list.");
            } catch (NotNumberException | IndexException | IOException err) {
                response.append(err.toString());
            }
        } else if (input.startsWith("find")) {
            String word = Parser.validateNonEmpty(input);
            response.append(tasks.toStringConditional(word));
        }
        else {
            throw new UnknownCommandException();
        }
        return response.toString();
    }
}
