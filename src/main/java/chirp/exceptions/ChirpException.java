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


    public static class InvalidCommand extends ChirpException {
        /**
         * Exception for unknown user command
         */
        public InvalidCommand() {
            super("Unknown Command");
        }
    }

    public static class TaskEmptyAttributeException extends ChirpException {
        /**
         * Exception for missing attribute
         *
         * @param taskType  What type of task requires this attribute
         * @param attribute Attribute tag
         */
        public TaskEmptyAttributeException(String taskType, String attribute) {
            super("The " + attribute + " attribute of a " + taskType + " task cannot be empty!");
        }
    }

    public static class TaskListOutOfBoundsException extends ChirpException {
        /**
         * Exception for out of bounds index access for tasklist
         *
         * @param idx  Invalid index used
         * @param size Size of task list
         */
        public TaskListOutOfBoundsException(int idx, int size) {
            super("Invalid index " + idx + ". There are " + size + " tasks in the list.");
        }
    }

    public static class CorruptedFile extends ChirpException {
        /**
         * Exception for corrupted task data file
         *
         * @param reason Type of file corruption
         */
        public CorruptedFile(String reason) {
            super("Corrupted File. Invalid Entry: " + reason);
        }
    }

    public static class InvalidAttribute extends ChirpException {
        /**
         * Exception for invalid attribute type
         *
         * @param data      Attribute value in input
         * @param attribute Attribute name
         * @param reason    Reason for invalid attribute
         */
        public InvalidAttribute(String data, String attribute, String reason) {
            super(String.format("Attribute %s \"%s\" is invalid: %s", attribute, data, reason));
        }
    }
}
