import java.util.Scanner;

public class Chirp {
    private static final String NAME = "Chirp";
    private static final Scanner sc = new Scanner(System.in);
    private static TaskList taskList;

    public static void main(String[] args) {
        greet();
        taskList = new TaskList();
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
            } else if (command.equals("deadline")) {
                // Deadline task
                String description = extractAttribute(input, "deadline");
                String endTime = extractAttribute(input, "/by");
                Task task = taskList.addDeadline(description, endTime);
                showAddedTask(task);
            } else if (command.equals("event")) {
                // Event task
                String description = extractAttribute(input, "event");
                String startTime = extractAttribute(input, "/from");
                String endTime = extractAttribute(input, "/to");
                Task task = taskList.addEvent(description, startTime, endTime);
                showAddedTask(task);
            } else if (command.equals("todo")) {
                // Todo task
                String description = extractAttribute(input, "todo");
                Task task = taskList.addTodo(description);
                showAddedTask(task);
            } else {
                throw new RuntimeException("Invalid Command");
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

    /**
     * Helper function to print exit message
     */
    private static void showAddedTask(Task task) {
        printLine();
        System.out.println(" Added task: " + task);
        System.out.println(" Currently " + taskList.getNumOfTasks() + " in the task list.");
        printLine();
    }

    /**
     * Given an input string extract attribute string
     * @param input The input string
     * @param attribute Attribute to search for
     * @return String immediately after the attribute in the input string
     *         until delimiter of / is reached.
     */
    private static String extractAttribute(String input, String attribute) {
        int startIndex = input.indexOf(attribute);
        if (startIndex != -1) {
            // Move past the attribute
            startIndex += attribute.length();

            // Find the next '/' after the attribute
            int endIndex = input.indexOf("/", startIndex);
            if (endIndex == -1) {
                // No delimiter after attribute
                endIndex = input.length();
            }

            // Extract the substring
            String value = input.substring(startIndex, endIndex).trim();
            return value;
        } else {
            throw new RuntimeException("No attribute " + attribute + " found in " + input);
        }
    }
}
