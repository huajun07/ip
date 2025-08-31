package chirp.exceptions;

public class InvalidCommandException extends ChirpException {

    /**
     * Exception for unknown user command
     */
    public InvalidCommandException() {
        super("Unknown Command");
    }
}
