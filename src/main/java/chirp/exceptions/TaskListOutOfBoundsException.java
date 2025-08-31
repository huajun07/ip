package chirp.exceptions;

/**
 * Exception for out of bounds index access for tasklist
 */
public class TaskListOutOfBoundsException extends ChirpException {
    /**
     * Create TaskListOutOfBoundsException
     *
     * @param idx  Invalid index used
     * @param size Size of task list
     */
    public TaskListOutOfBoundsException(int idx, int size) {
        super("Invalid index " + idx + ". There are " + size + " tasks in the list.");
    }
}
