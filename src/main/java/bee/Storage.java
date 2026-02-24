package bee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.time.format.DateTimeParseException;
import java.util.stream.Stream;


public class Storage {
    private Path path;
    /**
     *
     * @return tasklist loaded with descriptions in hard disk.
     * @throws IOException
     * @throws IndexOutOfBoundsException
     * @throws DateTimeParseException
     */
    public Storage() {
        path = Path.of("data", "tasks.txt");
    }
    public TaskList load() throws IndexOutOfBoundsException, DateTimeParseException, IOException {
        if (!Files.exists(path)) {
            Files.createDirectories(path.getParent());
            Files.createFile(path);
        }

        TaskList list = new TaskList();
        Stream<String> s = Files.lines(path);
        s.forEach(line -> {
            String input[] = line.split(" / ");
            if (input[0].equals("T")) {
                Todo t = new Todo(input[2], input[1].equals("1"));
                list.addTodo(t);
            }
            else if (input[0].equals("D")) {
                Deadline d = new Deadline(input[2], Parser.validateDate(input[3]), input[1].equals("1"));
                list.addDeadline(d);
            }
            else {
                Event e = new Event(input[2], Parser.validateDate(input[3]), Parser.validateDate(input[4]), input[1].equals("1"));
                list.addEvent(e);
            }
        });
        return list;
    }

    /**
     * updates hard disk upon changes to task list
     * @param list
     * @throws IOException
     */
    public void updateFile(TaskList list) throws IOException {
        Files.write(path, list.toStore().getBytes());
    }
}
