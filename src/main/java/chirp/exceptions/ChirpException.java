package chirp.exceptions;

public class ChirpException extends Exception {
    /**
     * Base checked exceptions for Chirp Bot
     *
     * @param reason Reason for the exception
     */
    public ChirpException(String reason) {
        super(reason);
    }
}
