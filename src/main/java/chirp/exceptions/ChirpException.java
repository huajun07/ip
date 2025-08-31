package chirp.exceptions;

/**
 * Base checked exceptions for Chirp Bot
 */
public class ChirpException extends Exception {
    /**
     * Create ChirpException
     *
     * @param reason Reason for the exception
     */
    public ChirpException(String reason) {
        super(reason);
    }
}
