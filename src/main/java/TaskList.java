public class TaskList {
    private static Task[] list = new Task[100];
    private static int length = 0;

    public static void addTodo(String name) {
        Task todo = new Todo(name);;
        list[length] = todo;
        length++;
        System.out.println(todo);
    }

    public static void addDeadline(String name, String by) {
        Task deadline = new Deadline(name, by);
        list[length] = deadline;
        length++;
        System.out.println(deadline);
    }

    public static void addEvent(String name, String to, String from) {
        Task event = new Event(name, to, from);
        list[length] = event;
        length++;
        System.out.println(event);
    }

    public static void listAllTasks() {
        for (int i = 0; i < length; i++) {
            System.out.println((i + 1) + ". " + list[i]);
        }
    }

    public static void doTask(Integer ind) {
        Task task = list[ind - 1];
        task.doTask();
        System.out.println(task);
    }

    public static void undoTask(Integer ind) {
        Task task = list[ind - 1];
        task.undoTask();
        System.out.println(task);
    }

    public static Integer getLength() {
        return length;
    }
}
