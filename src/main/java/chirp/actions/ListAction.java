package chirp.actions;

import java.time.LocalDate;

import chirp.exceptions.ChirpException;
import chirp.io.Attribute;
import chirp.io.Parser;
import chirp.io.Ui;
import chirp.tasks.TaskList;

/**
 * Action to list tasks
 */
public class ListAction extends Action {
    private LocalDate date;

    /**
     * Create ListAction from user input
     *
     * @param input User input to extract date filter
     * @throws ChirpException
     */
    public ListAction(String input) throws ChirpException {
        String dateStr = Parser.extractAttribute(input, Attribute.ON.getTag());
        date = null;
        if (!dateStr.isEmpty()) {
            date = Parser.convertDateAttr(dateStr, Attribute.ON.getTag());
        }
    }

    /**
     * List the tasks in the task list filtered by date
     *
     * @param taskList List of tasks
     * @param ui       UI interface
     */
    @Override
    public void execute(TaskList taskList, Ui ui) {
        ui.printMessage(taskList.displayStr(date));
    }
}
