package chirp.actions;

import java.util.Scanner;

import chirp.exceptions.ChirpException;
import chirp.io.Ui;
import chirp.tasks.TaskList;

public class MarkAction extends Action {
    private boolean isDone;
    private int index;

    public MarkAction(Command command, String input) {
        Scanner inputSc = new Scanner(input);
        inputSc.next();
        index = inputSc.nextInt() - 1;
        isDone = command == Command.MARK;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) throws ChirpException {
        taskList.markTask(index, isDone);
        ui.printMessage(" Modified task: " + taskList.getTask(index) + "\n");
    }
}
