package chirp.actions;

import chirp.exceptions.ChirpException;
import chirp.io.Ui;
import chirp.tasks.TaskList;

public abstract class Action {
    public abstract void execute(TaskList taskList, Ui ui) throws ChirpException;

    public boolean isExit() {
        return false;
    }
}
