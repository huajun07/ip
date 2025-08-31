package chirp.exceptions;

public class TaskListOutOfBoundsException extends ChirpException {
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
