import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import Exception.CorruptedFileException;

public class Storage {
    String filePath;

    Storage(String filePath) {
        this.filePath = filePath;
    }

    public TaskList load() throws FileNotFoundException, IndexOutOfBoundsException, DateTimeParseException {
        TaskList list = new TaskList();
        File f = new File(filePath);
        Scanner s = new Scanner(f);
;
        while (s.hasNext()) {
            String input[] = s.nextLine().split(" / ");
            if (input[0].equals("T")) {
                Todo t = new Todo(input[2], input[1].equals("1"));
                list.addTodo(t);
            }
            if (input[0].equals("D")) {
                Deadline d = new Deadline(input[2], Parser.validateDate(input[3]), input[1].equals("1"));
                list.addDeadline(d);
            }
            if (input[0].equals("E")) {
                Event e = new Event(input[2], Parser.validateDate(input[3]), Parser.validateDate(input[4]), input[1].equals("1"));
                list.addEvent(e);
            }
        }
        return list;
    }

    public void updateFile(TaskList list) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(list.toStore());
        fw.close();
    }
}
