public class EmptyAttributeException extends ChirpException {
    public EmptyAttributeException(String taskType, String attribute) {
        super("The " + attribute + " attribute of a " + taskType + " task cannot be empty!");
    }
}
