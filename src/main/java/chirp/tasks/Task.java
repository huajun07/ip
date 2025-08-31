package chirp.tasks;

import java.time.LocalDate;

import chirp.exceptions.ChirpException;
import chirp.exceptions.CorruptedFileException;
import chirp.exceptions.TaskEmptyAttributeException;

/**
 * Abstract base task object
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Abstract task constructor
     *
     * @param description Description of task
     * @throws ChirpException
     */
    public Task(String description) throws ChirpException {
        if (description.isEmpty()) {
            throw new TaskEmptyAttributeException("basic", "description");
        }
        this.description = description;
        this.isDone = false;
    }

    /**
     * Helper function to validate and extract the serialised data of the tasks
     *
     * @param data      Serialised data string
     * @param tag       Task tag
     * @param numFields Expected number of fields in data string
     * @return Array of fields extracted
     * @throws CorruptedFileException
     */
    protected static String[] deserialiseFields(String data, String tag, int numFields) throws CorruptedFileException {
        String[] fields = data.split("\\|");
        if (fields.length != numFields) {
            throw new CorruptedFileException("Wrong Number of Fields for tag " + tag);
        }
        if (!fields[0].equals(tag)) {
            throw new CorruptedFileException("Invalid Tag");
        }
        for (String field : fields) {
            if (field.isEmpty()) {
                throw new CorruptedFileException("Empty Field");
            }
        }
        return fields;
    }

    private String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Setter function of whether a task has been done
     *
     * @param isDone Set value
     */
    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Alternative setter of isDone using serialised string value
     *
     * @param data Either "X" or "O"
     */
    protected void setDone(String data) {
        this.isDone = data.equals("X");
    }

    /**
     * Function to be overriden to determine if a date filter applies to the task
     *
     * @param date Date filter
     * @return True for generic task
     */
    protected boolean validForDate(LocalDate date) {
        return true;
    }

    /**
     * @param filter Filter string
     * @return True if the task description contains the filter string
     */
    public boolean containsStr(String filter) {
        return description.toLowerCase().contains(filter.toLowerCase());
    }

    /**
     * @return Human-readable string representation of task
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Seralises task to data string
     *
     * @return Data string
     */
    public abstract String serialise();
}
