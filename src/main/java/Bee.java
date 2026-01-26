import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Bee");
        System.out.println("What can I do for you?");
        String input = sc.nextLine().toLowerCase();

        while (!input.equals("quit")) {
            if (input.isEmpty()) {
            } else if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                return;
            } else if (input.equals("list")) {
                System.out.println("Here are the tasks in your list: ");
                TaskList.listAllTasks();
            } else if (input.startsWith("mark")) {
                System.out.println("Nice! I've marked this task as done: ");
                TaskList.doTask(Integer.parseInt(input.split(" ")[1]));
            } else if (input.startsWith("unmark")) {
                System.out.println("OK, I've marked this task as not done yet: " );
                TaskList.undoTask(Integer.parseInt(input.split(" ")[1]));
            } else {
                TaskList.addTask(input);
            }
            input = sc.nextLine().toLowerCase();
        }
    }
}
