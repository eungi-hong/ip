public class TaskList {
    private static Task[] list = new Task[100];
    private static int length = 0;

    public static void addTask(String name) {
        list[length] = new Task(name);
        length++;
        System.out.println("added: " + name);
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
}
