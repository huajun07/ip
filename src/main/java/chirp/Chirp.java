package chirp;

import chirp.actions.Action;
import chirp.exceptions.ChirpException;
import chirp.io.MainWindow;
import chirp.io.Parser;
import chirp.io.Ui;
import chirp.tasks.TaskList;

/**
 * Main object of Chirp chatbot
 */
public class Chirp {
    private TaskList taskList;
    private Ui ui;
    private FileManager fileManager;
    private boolean isRunning;

    /**
     * Initialises chatbot before being run
     *
     * @param filePath Path to load task data file from
     */
    public Chirp(String filePath, MainWindow window) {
        ui = new Ui(window);
        isRunning = true;
        try {
            fileManager = new FileManager(filePath);
            taskList = fileManager.loadTasks();
        } catch (ChirpException e) {
            // Initialisation error
            ui.loadingError(e.getMessage());
            taskList = new TaskList();
        } catch (Exception e) {
            ui.fatalError(e.getMessage());
            isRunning = false;
        }
        ui.greet();
    }

    /**
     * Handles user input
     */
    public void handleUserInput(String input) {
        try {
            try {
                Action action = Parser.parse(input);
                action.execute(taskList, ui);
                if (action.isExit()) {
                    isRunning = false;
                }
            } catch (ChirpException e) {
                ui.inputError(e.getMessage());
            }
            fileManager.saveTasks(taskList);
        } catch (Exception e) {
            ui.fatalError(e.getMessage());
            isRunning = false;
        }
    }

    /**
     * Get isRunning boolean
     *
     * @return isRunning
     */
    public boolean getIsRunning() {
        return isRunning;
    }
}
