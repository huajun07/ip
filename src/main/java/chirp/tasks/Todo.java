package chirp.tasks;

import chirp.exceptions.ChirpException;

public class Todo extends Task {
    public static final String tag = "T";

    /**
     * Creates a task to be done
     *
     * @param description Task description
     * @throws ChirpException
     */
    public Todo(String description) throws ChirpException {
        super(description);
    }

    /**
     * Deserialise a data string to a Todo task object
     *
     * @param data Data string
     * @return The corresponding Todo task object
     * @throws ChirpException
     */
    public static Todo deserialise(String data) throws ChirpException {
        String[] fields = deserialiseFields(data, tag, 3);
        Todo task = new Todo(fields[2]);
        task.setDone(fields[1]);
        return task;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String serialise() {
        return String.format("%s|%s|%s", tag, isDone ? "X" : "O", description);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("[%s]%s", tag, super.toString());
    }
}
