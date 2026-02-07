import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import Exception.*;

public class Parser {
    public static LocalDate validateDate(String input) throws DateTimeParseException {
        return LocalDate.parse(input);
    }

    public static Integer validateIntInRange(String input, int min, int max) throws NotNumberException, IndexException {
        try {
            int i = Integer.parseInt(input);
            if (i < min || i > max) {
                throw new IndexException();
            } else {
                return i;
            }
        } catch (NumberFormatException err) {
            throw new NotNumberException();
        }
    }

    public static Todo validateTodo(String input) throws EmptyTaskException {
        String[] taskInfo = input.split("\s+", 2);
        if (taskInfo.length == 1) {
            throw new EmptyTaskException();
        } else {
            return new Todo(taskInfo[1], false);
        }
    }

    public static Deadline validateDeadline(String input) throws EmptyTaskException, NoDeadlineException, NotDateTimeException {
        String[] taskInfo = input.split("\s+", 2);
        if (taskInfo.length == 1) {
            throw new EmptyTaskException();
        }
        taskInfo = taskInfo[1].split(" /by ", 2);
        if (taskInfo.length == 1) {
            throw new NoDeadlineException();
        }
        try {
            LocalDate date = validateDate(taskInfo[1]);
            return new Deadline(taskInfo[0], date, false);
        } catch (DateTimeParseException err) {
            throw new NotDateTimeException();
        }
    }

    public static Event validateEvent(String input) throws EmptyTaskException, NoTimeFrameException, NotDateTimeException {
        String[] taskInfo = input.split("\s+", 2);
        if (taskInfo.length == 1) {
            throw new EmptyTaskException();
        }
        taskInfo = taskInfo[1].split(" /from ", 2);
        String name = taskInfo[0];
        if (taskInfo.length == 1) {
            throw new NoTimeFrameException();
        }
        taskInfo = taskInfo[1].split(" /to ", 2);
        if (taskInfo.length == 1) {
            throw new NoTimeFrameException();
        }
        try {
            LocalDate from = validateDate(taskInfo[0]);
            LocalDate to = validateDate(taskInfo[1]);
            return new Event(name, from, to, false);
        } catch (DateTimeParseException err) {
            throw new NotDateTimeException();
        }
    }
}
