import java.util.Scanner;

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
