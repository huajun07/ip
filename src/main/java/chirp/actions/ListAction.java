package chirp.actions;

import java.time.LocalDate;

import chirp.exceptions.ChirpException;
import chirp.io.Attribute;
import chirp.io.Parser;
import chirp.io.Ui;
import chirp.tasks.TaskList;

public class ListAction extends Action {
    private LocalDate date;

    public ListAction(String input) throws ChirpException {
        String dateStr = Parser.extractAttribute(input, Attribute.ON.getTag());
        date = null;
        if (!dateStr.isEmpty()) {
            date = Parser.convertDateAttr(dateStr, Attribute.ON.getTag());
        }
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        ui.printMessage(taskList.displayStr(date));
    }
}
