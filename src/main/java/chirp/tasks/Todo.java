package chirp.tasks;
import chirp.exceptions.ChirpException;

public class Todo extends Task {
    public static final String tag = "T";

    public Todo(String description) throws ChirpException {
        super(description);
    }

    public static Todo deserialise(String data) throws ChirpException {
        String[] fields = deserialiseFields(data, tag, 3);
        Todo task = new Todo(fields[2]);
        task.setDone(fields[1]);
        return task;
    }

    @Override
    public String serialise() {
        return String.format("%s|%s|%s", tag, isDone ? "X" : "O", description);
    }

    @Override
    public String toString() {
        return String.format("[%s]%s", tag, super.toString());
    }
}
