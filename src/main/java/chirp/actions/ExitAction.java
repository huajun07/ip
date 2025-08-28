package chirp.actions;

import chirp.io.Ui;
import chirp.tasks.TaskList;

public class ExitAction extends Action {

    /**
     * Terminate the chat bot
     *
     * @param taskList List of tasks
     * @param ui       UI interface
     */
    @Override
    public void execute(TaskList taskList, Ui ui) {
        ui.exit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
