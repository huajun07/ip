public abstract class Action {
    public abstract void execute(TaskList taskList, Ui ui) throws ChirpException;

    public boolean isExit() {
        return false;
    }
}
