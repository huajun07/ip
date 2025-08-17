public class TaskListOutOfBoundsException extends ChirpException {
    public TaskListOutOfBoundsException(int idx, int size) {
        super("Invalid index " + idx + ". There are " + size + " tasks in the list.");
    }
}
