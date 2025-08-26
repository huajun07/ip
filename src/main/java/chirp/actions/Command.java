package chirp.actions;
import chirp.exceptions.ChirpException;

public enum Command {
    BYE("bye"),
    LIST("list"),
    MARK("mark"),
    UNMARK("unmark"),
    DELETE("delete"),
    DEADLINE("deadline"),
    EVENT("event"),
    TODO("todo");

    private final String keyword;

    Command(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    /**
     * Convert string keyword to command enum
     * @param input the keyword
     * @return the corresponding command enum
     * @throws ChirpException If input is not a valid keyword
     */
    public static Command fromString(String input) throws ChirpException {
        for (Command cmd : Command.values()) {
            if (cmd.keyword.equals(input)) {
                return cmd;
            }
        }
        throw new ChirpException.InvalidCommand();
    }
}
