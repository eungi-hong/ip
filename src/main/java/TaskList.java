public class TaskList {
    private static String[] list = new String[100];
    private static int length = 0;

    public static void addTask(String name) {
        list[length] = name;
        length++;
        System.out.println(name);
    }

    public static void listAllTasks() {
        for (int i = 0; i < length; i++) {
            System.out.println((i + 1) + ". " + list[i]);
        }
    }
}
