package chirp.exceptions;

/**
 * Exception for unknown user command
 */
public class InvalidCommandException extends ChirpException {

    /**
     * Create InvalidCommandException
     */
    public InvalidCommandException() {
        super("Unknown Command");
    }
}
