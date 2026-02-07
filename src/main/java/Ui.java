import java.util.Scanner;

public class Ui {
    Scanner sc = new Scanner(System.in);

    public String nextLine() {
        return sc.nextLine().toLowerCase();
    }

    public void output(String content) {
        System.out.println(content);
    }
}
