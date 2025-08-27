package chirp.tasks;
import java.time.LocalDate;

import chirp.exceptions.ChirpException;
import chirp.io.Attribute;
import chirp.io.Parser;

public class Deadline extends Task {
    public static final String tag = "D";
    private LocalDate endTime;

    public Deadline(String description, String endTime) throws ChirpException {
        super(description);
        if (endTime.isEmpty()) {
            throw new ChirpException.TaskEmptyAttributeException("event", Attribute.BY.getTag());
        }
        this.endTime = Parser.convertDateAttr(endTime, Attribute.BY.getTag());
    }

    public static Deadline deserialise(String data) throws ChirpException {
        String[] fields = deserialiseFields(data, tag, 4);
        Deadline task = new Deadline(fields[2], fields[3]);
        task.setDone(fields[1]);
        return task;
    }

    @Override
    public String serialise() {
        return String.format("%s|%s|%s|%s", tag, isDone ? "X" : "O", description, endTime);
    }

    @Override
    public String toString() {
        return String.format("[%s]%s (by: %s)", tag, super.toString(), endTime);
    }

    @Override
    public boolean validForDate(LocalDate date) {
        if (date == null) return true;
        return date.isEqual(endTime);
    }
}
