import java.util.Scanner;
import Exception.BeeException;
import java.io.File;
import java.io.FileNotFoundException;

public class Bee {
    private static void readTasks(String filePath) throws FileNotFoundException, IndexOutOfBoundsException {
        File f = new File(filePath);
        Scanner s = new Scanner(f);

        while (s.hasNext()) {
            String[] input = s.nextLine().split(" / ");
            if (input[0].equals("T")) {
                TaskList.addTodo(input[2], input[1].equals("1") ? true : false);
            }
            if (input[0].equals("D")) {
                TaskList.addDeadline(input[2], input[3], input[1].equals("1") ? true : false);
            }
            if (input[0].equals("E")) {
                TaskList.addEvent(input[2], input[3], input[4], input[1].equals("1") ? true : false);
            }
        }
    }

    public static void main(String[] args) {
        try {
            readTasks("src/main/java/data/tasks.txt");
        } catch (FileNotFoundException err) {
            System.out.println("Missing data file!");
        } catch (IndexOutOfBoundsException err) {
            System.out.println("Corrupted data file!");
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Bee");
        System.out.println("What can I do for you?");
        String input = sc.nextLine().toLowerCase();

        while (true) {
            if (input.isEmpty()) {
            }
            else if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                return;
            } else {
                try {
                    Handler.handle(input);
                } catch (BeeException e) {
                    System.out.println(e.getMessage());
                }
            }
            input = sc.nextLine().toLowerCase();
        }
    }
}
