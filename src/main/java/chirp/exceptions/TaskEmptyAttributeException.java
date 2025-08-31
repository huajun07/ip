package chirp.exceptions;

/**
 * Exception for missing attribute
 */
public class TaskEmptyAttributeException extends ChirpException {
    /**
     * Create TaskEmptyAttributeException
     *
     * @param taskType  What type of task requires this attribute
     * @param attribute Attribute tag
     */
    public TaskEmptyAttributeException(String taskType, String attribute) {
        super("The " + attribute + " attribute of a " + taskType + " task cannot be empty!");
    }
}
