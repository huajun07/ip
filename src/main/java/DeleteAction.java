import java.util.Scanner;

public class DeleteAction extends Action {
    private int index;

    public DeleteAction(String input) {
        Scanner inputSc = new Scanner(input);
        inputSc.next();
        index = inputSc.nextInt() - 1;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) throws ChirpException {
        Task task = taskList.deleteTask(index);
        ui.printMessage(" Delete task: " + task + "\n" + ui.taskListCount(taskList) + "\n");
    }
}
