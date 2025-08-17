import java.util.Scanner;

public class Chirp {
    private static final String NAME = "Chirp";
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        greet();
        TaskList taskList = new TaskList();
        while (true) {
            String input = prompt();
            Scanner inputSc = new Scanner(input);
            String command = inputSc.next();
            if (command.equals("bye")) {
                // Terminate the chatbot
                exit();
                break;
            } else if (command.equals("list")) {
                // List tasks
                printLine();
                taskList.display();
                printLine();
            } else if (command.equals("mark") || command.equals("unmark")) {
                // Mark/Unmark task
                boolean isDone = command.equals("mark");
                // taskList accepts 0-index
                int idx = inputSc.nextInt() - 1;
                taskList.markTask(idx, isDone);
                printLine();
                System.out.println(" Modified task: " + taskList.getTask(idx));
                printLine();
            } else {
                // Add task to list
                taskList.addTask(input);
                printLine();
                System.out.println(" Added: " + input);
                printLine();
            }
        }
    }

    /**
     * Prompts the user for an input
     * @return Input by user
     */
    private static String prompt() {
        System.out.print("> ");
        String input = sc.nextLine();
        return input;
    }

    /**
     * Helper function to print horizontal line
     */
    private static void printLine() {
        System.out.println("-".repeat(60));
    }

    /**
     * Helper function to print greeting message
     */
    private static void greet() {
        printLine();
        System.out.println(" Hello! I'm " + NAME);
        System.out.println(" What can I do for you?");
        printLine();
    }

    /**
     * Helper function to print exit message
     */
    private static void exit() {
        printLine();
        System.out.println(" Bye. Hope to see you again soon!");
        printLine();
    }
}
