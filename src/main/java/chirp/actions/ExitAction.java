package chirp.actions;

import chirp.io.Ui;
import chirp.tasks.TaskList;

public class ExitAction extends Action {
    @Override
    public void execute(TaskList taskList, Ui ui) {
        ui.exit();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
