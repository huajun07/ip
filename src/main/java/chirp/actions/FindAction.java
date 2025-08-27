package chirp.actions;

import java.time.LocalDate;

import chirp.exceptions.ChirpException;
import chirp.io.Attribute;
import chirp.io.Parser;
import chirp.io.Ui;
import chirp.tasks.TaskList;

public class FindAction extends Action {
    private String filter;

    /**
     * Create FindAction from user input
     *
     * @param input User input to extract string filter
     * @throws ChirpException
     */
    public FindAction(String input) throws ChirpException {
        filter = Parser.extractAttribute(input, Command.FIND.getKeyword());
        if (filter.isEmpty()) {
            throw new ChirpException.InvalidAttribute("", "find", "Empty find filter");
        }
    }

    /**
     * Finds tasks that contain filter string
     *
     * @param taskList List of tasks
     * @param ui       UI interface
     */
    @Override
    public void execute(TaskList taskList, Ui ui) {
        ui.printMessage("Here are the matching tasks in your list:\n" + taskList.displayStr(filter));
    }
}
