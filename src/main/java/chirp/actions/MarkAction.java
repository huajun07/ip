package chirp.actions;

import java.util.Scanner;

import chirp.exceptions.ChirpException;
import chirp.io.Ui;
import chirp.tasks.TaskList;

public class MarkAction extends Action {
    private boolean isDone;
    private int index;

    /**
     * Create MarkAction from user input
     *
     * @param command Command used to determine whether to mark or unmark
     * @param input   User input to extract date filter
     * @throws ChirpException
     */
    public MarkAction(Command command, String input) {
        Scanner inputSc = new Scanner(input);
        inputSc.next();
        index = inputSc.nextInt() - 1;
        isDone = command == Command.MARK;
    }

    /**
     * Mark/Unmark task
     *
     * @param taskList List of tasks
     * @param ui       UI interface
     */
    @Override
    public void execute(TaskList taskList, Ui ui) throws ChirpException {
        taskList.markTask(index, isDone);
        ui.printMessage(" Modified task: " + taskList.getTask(index) + "\n");
    }
}
