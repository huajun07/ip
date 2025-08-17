import java.util.Scanner;

public class Chirp {
    private static final String name = "Chirp";
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        greet();
        while (true) {
            String input = prompt();
            if (input.equals("bye")) {
                exit();
                break;
            } else {
                echo(input);
            }
        }
    }

    private static String prompt() {
        System.out.print("> ");
        String input = sc.nextLine();
        return input;
    }

    private static void printLine() {
        System.out.println("-".repeat(60));
    }

    private static void greet() {
        printLine();
        System.out.println(" Hello! I'm " + name);
        System.out.println(" What can I do for you?");
        printLine();
    }

    private static void exit() {
        printLine();
        System.out.println(" Bye. Hope to see you again soon!");
        printLine();
    }

    private static void echo(String str) {
        printLine();
        System.out.println(str);
        printLine();
    }

}
