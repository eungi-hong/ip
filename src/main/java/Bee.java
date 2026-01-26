import java.util.Locale;
import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Bee");
        System.out.println("What can I do for you?");
        String input;

        while (!((input = sc.nextLine().toLowerCase()).equals("bye"))) {
            System.out.println(input);
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
