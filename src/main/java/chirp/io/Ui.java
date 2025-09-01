package chirp.io;

import chirp.tasks.TaskList;

/**
 * Helper class to manage input and output with the user
 */
public class Ui {
    private static final String NAME = "Chirp";
    private MainWindow window;

    /**
     * Create Ui Object
     *
     * @param window Display window
     */
    public Ui(MainWindow window) {
        this.window = window;
    }

    /**
     * Display a message to the user
     *
     * @param message Message to display
     */
    public void printMessage(String message) {
        window.sendChirpMessage(message);
    }

    /**
     * Informs the user that a unrecoverable error has occurred and the chat is terminated
     *
     * @param error The error message
     */
    public void fatalError(String error) {
        String data = " FATAL: " + error + "\n" + " Shutting down...\n";
        printMessage(data);
    }

    /**
     * Informs the user that an error has occurred during the loading of the data file
     * and the task list is defaulted to being empty
     *
     * @param error The error message
     */
    public void loadingError(String error) {
        String data = " Error in loading: " + error + "\n" + " Defaulting to empty task list.\n";
        printMessage(data);
    }

    /**
     * Informs the user that an error has occurred due to invalid input
     *
     * @param error The error message
     */
    public void inputError(String error) {
        String data = " Invalid Input: " + error + "\n" + " Please try again!\n";
        printMessage(data);
    }

    /**
     * Helper function to print greeting message
     */
    public void greet() {
        String data = " Hello! I'm " + NAME + "\n" + " What can I do for you?\n";
        printMessage(data);
    }

    /**
     * Helper function to print farewell message
     */
    public void exit() {
        printMessage(" Bye. Hope to see you again soon!\n");
    }

    /**
     * Helper function to return info string on number of tasks in tasklist
     *
     * @param taskList
     * @return Info string
     */
    public String taskListCount(TaskList taskList) {
        return " Currently " + taskList.getNumOfTasks() + " tasks in the task list.";
    }
}
