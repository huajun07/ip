package chirp.io;
import java.util.Scanner;

import chirp.tasks.TaskList;

public class Ui {
    private static final String NAME = "Chirp";
    private static final Scanner sc = new Scanner(System.in);

    public Ui() {}

    /**
     * Helper function to print horizontal line
     */
    private void printLine() {
        System.out.println("-".repeat(60));
    }

    public void printMessage(String message) {
        printLine();
        System.out.print(message);
        printLine();
    }

    /**
     * Prompts the user for an input
     * @return Input by user
     */
    public String prompt() {
        System.out.print("> ");
        return sc.nextLine();
    }

    public void fatalError(String error) {
        String data = " FATAL: " + error + "\n" +
                      " Shutting down...\n";
        printMessage(data);
    }

    public void loadingError(String error) {
        String data = " Error in loading: " + error + "\n" +
                      " Defaulting to empty task list.\n";
        printMessage(data);
    }

    public void inputError(String error) {
        String data = " Invalid Input: " + error + "\n" +
                      " Please try again!\n";
        printMessage(data);
    }

    /**
     * Helper function to print greeting message
     */
    public void greet() {
        String data = " Hello! I'm " + NAME + "\n" +
                      " What can I do for you?\n";
        printMessage(data);
    }

    public void exit() {
        printMessage(" Bye. Hope to see you again soon!\n");
    }

    public String taskListCount(TaskList taskList) {
        return " Currently " + taskList.getNumOfTasks() + " tasks in the task list.";
    }
}
