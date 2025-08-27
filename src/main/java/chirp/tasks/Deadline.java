package chirp.tasks;

import java.time.LocalDate;

import chirp.exceptions.ChirpException;
import chirp.io.Attribute;
import chirp.io.Parser;

public class Deadline extends Task {
    public static final String tag = "D";
    private LocalDate endTime;

    /**
     * Creates a task with a deadline
     * @param description Task description
     * @param endTime Deadline in yyyy-MM-dd format
     * @throws ChirpException
     */
    public Deadline(String description, String endTime) throws ChirpException {
        super(description);
        if (endTime.isEmpty()) {
            throw new ChirpException.EmptyAttributeException("event", Attribute.BY.getTag());
        }
        this.endTime = Parser.convertDateAttr(endTime, Attribute.BY.getTag());
    }

    /**
     * Deserialise a data string to a deadline task object
     * @param data Data string
     * @return The corresponding deadline task object
     * @throws ChirpException
     */
    public static Deadline deserialise(String data) throws ChirpException {
        String[] fields = deserialiseFields(data, tag, 4);
        Deadline task = new Deadline(fields[2], fields[3]);
        task.setDone(fields[1]);
        return task;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String serialise() {
        return String.format("%s|%s|%s|%s", tag, isDone ? "X" : "O", description, endTime);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("[%s]%s (by: %s)", tag, super.toString(), endTime);
    }

    /**
     * @param date Date filter
     * @return True if date filter is same as deadline
     */
    @Override
    public boolean validForDate(LocalDate date) {
        if (date == null) return true;
        return date.isEqual(endTime);
    }
}
