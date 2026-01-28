import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Bee");
        System.out.println("What can I do for you?");
        String input = sc.nextLine().toLowerCase();

        while (true) {
            if (input.isEmpty()) {
            } else if (input.equals("bye")) {
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
