import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Bee");
        System.out.println("What can I do for you?");
        String input = sc.nextLine().toLowerCase();

        while (!input.equals("quit")) {
            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                return;
            } else if (input.equals("list")) {
                TaskList.listAllTasks();
            } else {
                TaskList.addTask(input);
            }
            input = sc.nextLine().toLowerCase();
        }
    }
}
