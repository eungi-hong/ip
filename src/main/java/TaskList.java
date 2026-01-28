import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> list = new ArrayList<>();

    public static void addTodo(String name) {
        Task todo = new Todo(name);;
        list.add(todo);
        System.out.println(todo);
    }

    public static void addDeadline(String name, String by) {
        Task deadline = new Deadline(name, by);
        list.add(deadline);
        System.out.println(deadline);
    }

    public static void addEvent(String name, String to, String from) {
        Task event = new Event(name, to, from);
        list.add(event);
        System.out.println(event);
    }

    public static void listAllTasks() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public static void doTask(Integer ind) {
        Task task = list.get(ind - 1);
        task.doTask();
        System.out.println(task);
    }

    public static void undoTask(Integer ind) {
        Task task = list.get(ind - 1);
        task.undoTask();
        System.out.println(task);
    }

    public static void deleteTask(Integer ind) {
        Task task = list.remove(ind - 1);
        System.out.println(task);
    }

    public static Integer getLength() {
        return list.size();
    }
}
