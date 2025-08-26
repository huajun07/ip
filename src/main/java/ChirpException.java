public class ChirpException extends Exception {
    public ChirpException(String reason) {
        super(reason);
    }

    public static class EmptyAttributeException extends ChirpException {
        public EmptyAttributeException(String taskType, String attribute) {
            super("The " + attribute + " attribute of a " + taskType + " task cannot be empty!");
        }
    }

    public static class TaskListOutOfBoundsException extends ChirpException {
        public TaskListOutOfBoundsException(int idx, int size) {
            super("Invalid index " + idx + ". There are " + size + " tasks in the list.");
        }
    }
}
