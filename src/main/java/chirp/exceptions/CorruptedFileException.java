package chirp.exceptions;

public class CorruptedFileException extends ChirpException {
    /**
     * Exception for corrupted task data file
     *
     * @param reason Type of file corruption
     */
    public CorruptedFileException(String reason) {
        super("Corrupted File. Invalid Entry: " + reason);
    }
}
