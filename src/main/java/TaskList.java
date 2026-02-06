import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TaskList {
    private static ArrayList<Task> list = new ArrayList<>();

    private static void updateFile() {
        StringBuilder tasks = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            tasks.append("/n" + list.get(i).toStore());
        }
        try {
            FileWriter fw = new FileWriter("src/main/java/data/tasks.txt");
            fw.write(tasks.toString());
            fw.close();
        } catch (IOException err) {
            System.out.println("Error in data file!");
        }
    }

    public static void addTodo(String name, boolean isDone) {
        Task todo = new Todo(name, isDone);;
        list.add(todo);
        updateFile();
    }

    public static void addDeadline(String name, String by, boolean isDone) throws DateTimeParseException {
        Task deadline = new Deadline(name, LocalDate.parse(by), isDone);
        list.add(deadline);
        updateFile();
    }

    public static void addEvent(String name, String to, String from, boolean isDone) throws DateTimeParseException {
        Task event = new Event(name, LocalDate.parse(to), LocalDate.parse(from), isDone);
        list.add(event);
        updateFile();
    }

    public static void listAllTasks() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public static void printLastTask() {
        System.out.println(list.get(list.size() - 1));
    }

    public static void doTask(Integer ind) {
        Task task = list.get(ind - 1);
        task.doTask();
        System.out.println(task);
        updateFile();
    }

    public static void undoTask(Integer ind) {
        Task task = list.get(ind - 1);
        task.undoTask();
        System.out.println(task);
        updateFile();
    }

    public static void deleteTask(Integer ind) {
        Task task = list.remove(ind - 1);
        System.out.println(task);
        updateFile();
    }

    public static Integer getLength() {
        return list.size();
    }
}
