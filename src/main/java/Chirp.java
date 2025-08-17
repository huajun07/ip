import java.util.Scanner;

public class Chirp {
    private static final String NAME = "Chirp";
    private static final Scanner sc = new Scanner(System.in);
    private static TaskList taskList;

    public static void main(String[] args) {
        greet();
        taskList = new TaskList();
        boolean running = true;
        while (running) {
            String input = prompt();
            try {
                Scanner inputSc = new Scanner(input);
                Command command = Command.fromString(inputSc.next());
                switch (command) {
                    case LIST -> {
                        // List tasks
                        printLine();
                        taskList.display();
                        printLine();
                    }
                    case MARK, UNMARK -> {
                        // Mark / Unmark task
                        boolean isDone = command == Command.MARK;
                        // taskList accepts 0-index
                        int idx = inputSc.nextInt() - 1;
                        taskList.markTask(idx, isDone);
                        printLine();
                        System.out.println(" Modified task: " + taskList.getTask(idx));
                        printLine();
                    }
                    case DELETE -> {
                        // Delete task
                        int idx = inputSc.nextInt() - 1;
                        Task task = taskList.deleteTask(idx);
                        printLine();
                        System.out.println(" Delete task: " + task);
                        showTaskListSize();
                        printLine();
                    }
                    case TODO -> {
                        // Todo task
                        String description = extractAttribute(input, Command.TODO.getKeyword());
                        Todo task = taskList.addTodo(description);
                        showAddedTask(task);
                    }
                    case DEADLINE -> {
                        // Deadline task
                        String description = extractAttribute(input, Command.DEADLINE.getKeyword());
                        String endTime = extractAttribute(input, Attribute.BY.getTag());
                        Deadline task = taskList.addDeadline(description, endTime);
                        showAddedTask(task);
                    }
                    case EVENT -> {
                        // Event task
                        String description = extractAttribute(input, Command.EVENT.getKeyword());
                        String startTime = extractAttribute(input, Attribute.FROM.getTag());
                        String endTime = extractAttribute(input, Attribute.TO.getTag());
                        Event task = taskList.addEvent(description, startTime, endTime);
                        showAddedTask(task);
                    }
                    case BYE -> {
                        // Terminate the chatbot
                        exit();
                        running = false;
                    }
                }
            } catch (ChirpException e) {
                printLine();
                System.out.println(" Invalid Input: " + e.getMessage());
                System.out.println(" Please try again!");
                printLine();
            } catch (Exception e) {
                printLine();
                System.out.println(" FATAL: " + e.getMessage());
                System.out.println(" Shutting down...");
                printLine();
                running = false;
            }
        }
    }

    /**
     * Prompts the user for an input
     * @return Input by user
     */
    private static String prompt() {
        System.out.print("> ");
        return sc.nextLine();
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
     * Helper function to print added task
     * @param task Task addded
     */
    private static void showAddedTask(Task task) {
        printLine();
        System.out.println(" Added task: " + task);
        showTaskListSize();
        printLine();
    }

    /**
     * Helper function to print number of tasks in task list
     */
    private static void showTaskListSize() {
        System.out.println(" Currently " + taskList.getNumOfTasks() + " tasks in the task list.");
    }

    /**
     * Given an input string extract attribute string
     * @param input The input string
     * @param attribute Attribute to search for
     * @return String immediately after the attribute in the input string
     *         until delimiter of / is reached. If the attribute is not found
     *         an empty string is returned.
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
            return input.substring(startIndex, endIndex).trim();
        } else {
            return "";
        }
    }
}
