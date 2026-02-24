package bee;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import bee.Exception.BeeException;
import bee.Exception.EmptyTaskException;
import bee.Exception.IndexException;
import bee.Exception.NotNumberException;
import bee.Exception.UnknownCommandException;

/**
 * Handles user input and executes corresponding commands.
 */
public class Handler {
    /**
     * Outputs appropriate response to user input.
     * @param input
     * @param storage
     * @param tasks
     * @throws BeeException
     */
    public static String handle(String input, Storage storage, TaskList tasks) throws BeeException {
        StringBuilder response = new StringBuilder();

        if (input.equals("list")) {
            response.append("Here are the tasks in your list:\n");
            response.append(tasks.toString());
        }
        else if (input.startsWith("mark")) {
            try {
                Integer ind = Parser.validateIntInRange(input.split(" ")[1], 1, tasks.getLength());
                assert 0 <= ind && ind < tasks.getLength() : "index should be within range";
                tasks.doTask(ind);
                storage.updateFile(tasks);
                response.append("Nice! I've marked this task as done:\n");
                response.append(tasks.getTask(ind).toString());
            } catch (NotNumberException | IndexException | IOException err) {
                response.append(err);
            }
        }
        else if (input.startsWith("unmark")) {
            try {
                Integer ind = Parser.validateIntInRange(input.split(" ")[1], 1, tasks.getLength());
                assert 0 <= ind && ind < tasks.getLength() : "index should be within range";
                tasks.undoTask(ind);
                storage.updateFile(tasks);
                response.append("Oops! I've marked this task as not done yet:\n");
                response.append(tasks.getTask(ind).toString());
            } catch (NotNumberException | IndexException | IOException err) {
                response.append(err);
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
                response.append(err);
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
                response.append(err);
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
                response.append(err);
            }
        }
        else if (input.startsWith("delete")) {
            try {
                Integer ind = Parser.validateIntInRange(input.split(" ")[1], 1, tasks.getLength());
                assert 0 <= ind && ind < tasks.getLength() : "index should be within range";
                Task task = tasks.getTask(ind);
                tasks.deleteTask(ind);
                storage.updateFile(tasks);
                response.append("Noted. I've removed this task:\n");
                response.append(task.toString());
                response.append("\nNow you have " + tasks.getLength() + " tasks in the list.");
            } catch (NotNumberException | IndexException | IOException err) {
                response.append(err);
            }
        }
        else if (input.startsWith("find")) {
            String word = Parser.validateNonEmpty(input);
            response.append(tasks.toStringConditional(word));
        }
        else if (input.startsWith("postpone deadline")) {
            try {
                Integer ind = Parser.validateIntInRange(input.split(" ")[2], 1, tasks.getLength());
                assert 1 <= ind && ind <= tasks.getLength() : "index should be within range";
                LocalDate date = Parser.validateDate(input.split(" ")[3]);
                tasks.postpone(ind, date);

                Task task = tasks.getTask(ind);
                storage.updateFile(tasks);
                response.append("Noted. I've postponed this task:\n");
                response.append(task.toString());

            } catch (NotNumberException | IndexException | DateTimeParseException err) {
                response.append(err);
            } catch (UnknownCommandException | IOException err) {
                response.append(err);
            }
        } else if (input.startsWith("postpone event")) {
            try {
                Integer ind = Parser.validateIntInRange(input.split(" ")[2], 1, tasks.getLength());
                assert 1 <= ind && ind <= tasks.getLength() : "index should be within range";
                LocalDate to = Parser.validateDate(input.split(" ")[3]);
                LocalDate from = Parser.validateDate(input.split(" ")[4]);
                tasks.postpone(ind, to, from);

                Task task = tasks.getTask(ind);
                storage.updateFile(tasks);
                response.append("Noted. I've postponed this task:\n");
                response.append(task.toString());

            } catch (NotNumberException | IndexException | DateTimeParseException err) {
                response.append(err);
            } catch (UnknownCommandException | IOException err) {
                response.append(err);
            }
        }
        else {
            throw new UnknownCommandException();
        }
        return response.toString();
    }
}
