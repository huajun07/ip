package chirp;

import chirp.actions.Action;
import chirp.exceptions.ChirpException;
import chirp.io.Parser;
import chirp.io.Ui;
import chirp.tasks.TaskList;

public class Chirp {
    private TaskList taskList;
    private Ui ui;
    private FileManager fileManager;
    private boolean running;

    /**
     * Initialises chatbot before being run
     * @param filePath Path to load task data file from
     */
    public Chirp(String filePath) {
        ui = new Ui();
        running = true;
        try {
            fileManager = new FileManager(filePath);
            taskList = fileManager.loadTasks();
        } catch (ChirpException e) {
            // Initialisation error
            ui.loadingError(e.getMessage());
            taskList = new TaskList();
        } catch (Exception e) {
            ui.fatalError(e.getMessage());
            running = false;
        }
    }

    /**
     * Runs the chatbot, handling user input
     */
    public void run() {
        ui.greet();
        try {
            while (running) {
                String input = ui.prompt();
                try {
                    Action action = Parser.parse(input);
                    action.execute(taskList, ui);
                    if (action.isExit()) {
                        running = false;
                    }
                } catch (ChirpException e) {
                    ui.inputError(e.getMessage());
                }
                fileManager.saveTasks(taskList);
            }
        } catch (Exception e) {
            ui.fatalError(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Chirp("data/tasks.txt").run();
    }
}
