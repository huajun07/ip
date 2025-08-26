package chirp.io;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

import chirp.actions.Action;
import chirp.actions.AddAction;
import chirp.actions.DeleteAction;
import chirp.actions.ExitAction;
import chirp.actions.ListAction;
import chirp.actions.MarkAction;
import chirp.actions.Command;
import chirp.exceptions.ChirpException;

public class Parser {
    /**
     * Given an input string extract attribute string
     * @param input The input string
     * @param attribute Attribute to search for
     * @return String immediately after the attribute in the input string
     *         until delimiter of / is reached. If the attribute is not found
     *         an empty string is returned.
     */
    public static String extractAttribute(String input, String attribute) {
        int startIndex = input.indexOf(attribute);
        if (startIndex != -1) {
            // Move past the attribute
            startIndex += attribute.length();

            // Find the next '/' after the attribute
            int endIndex = input.indexOf("/", startIndex);
            if (endIndex == -1) {
                // No delimiter after attribute
                endIndex = input.length();
            }

            // Extract the substring
            return input.substring(startIndex, endIndex).trim();
        } else {
            return "";
        }
    }

    public static LocalDate convertDateAttr(String data, String attribute) throws ChirpException {
        try {
            return LocalDate.parse(data);
        } catch (DateTimeException e) {
            throw new ChirpException.InvalidAttribute(data, attribute, "Not in yyyy-MM-dd format.");
        }
    }

    public static Action parse(String input) throws ChirpException {
        Scanner inputSc = new Scanner(input);
        Command command = Command.fromString(inputSc.next());
        switch (command) {
            case LIST -> {
                // List tasks
                return new ListAction(input);
            }
            case MARK, UNMARK -> {
                // Mark / Unmark task
                return new MarkAction(command, input);
            }
            case DELETE -> {
                return new DeleteAction(input);
            }
            case TODO, DEADLINE, EVENT -> {
                return new AddAction(command, input);
            }
            case BYE -> {
                return new ExitAction();
            }
        }
        throw new ChirpException.InvalidCommand();
    }
}
