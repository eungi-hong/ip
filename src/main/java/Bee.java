import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Bee");
        System.out.println("What can I do for you?");
        String input = sc.nextLine().toLowerCase();

        while (!input.equals("quit")) {
            if (input.isEmpty()) {
            }
            else if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                return;
            }
            else if (input.equals("list")) {
                System.out.println("Here are the tasks in your list: ");
                TaskList.listAllTasks();
            }
            else if (input.startsWith("mark")) {
                System.out.println("Nice! I've marked this task as done: ");
                TaskList.doTask(Integer.parseInt(input.split(" ")[1]));
            }
            else if (input.startsWith("unmark")) {
                System.out.println("OK, I've marked this task as not done yet: " );
                TaskList.undoTask(Integer.parseInt(input.split(" ")[1]));
            }

            // add tasks
            else if (input.startsWith("todo")) {
                String name = input.split("\s+", 2)[1];
                System.out.println("Got it. I've added this task:");
                TaskList.addTodo(name);
                System.out.println("Now you have " + TaskList.getLength() + " tasks in the list.");
            }
            else if (input.startsWith("deadline")) {
                System.out.println("Got it. I've added this task:");
                String taskInfo = input.split("\s+", 2)[1];
                String[] arr = taskInfo.split(" /by ");
                TaskList.addDeadline(arr[0], arr[1]);
                System.out.println("Now you have " + TaskList.getLength() + " tasks in the list.");
            }
            else if (input.startsWith("event")) {
                System.out.println("Got it. I've added this task:");
                String taskInfo = input.split("\s+", 2)[1];
                String[] arr = taskInfo.split(" /from ");
                String name = arr[0];
                String timeInfo = arr[1];
                String[] arr2 = timeInfo.split(" /to ");
                String from = arr2[0];
                String to = arr2[1];

                TaskList.addEvent(name, from ,to);
                System.out.println("Now you have " + TaskList.getLength() + " tasks in the list.");
            }

            input = sc.nextLine().toLowerCase();
        }
    }
}
