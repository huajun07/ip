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
