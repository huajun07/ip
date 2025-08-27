package chirp.tasks;

import java.time.LocalDate;

import chirp.exceptions.ChirpException;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) throws ChirpException {
        if (description.isEmpty()) {
            throw new ChirpException.EmptyAttributeException("basic", "description");
        }
        this.description = description;
        this.isDone = false;
    }

    protected static String[] deserialiseFields(String data, String tag, int numOfFields) throws ChirpException.CorruptedFile {
        String[] fields = data.split("\\|");
        if (fields.length != numOfFields) {
            throw new ChirpException.CorruptedFile("Wrong Number of Fields for tag " + tag);
        }
        if (!fields[0].equals(tag)) {
            throw new ChirpException.CorruptedFile("Invalid Tag");
        }
        for (String field : fields) {
            if (field.isEmpty()) {
                throw new ChirpException.CorruptedFile("Empty Field");
            }
        }
        return fields;
    }

    private String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    protected void setDone(String data) {
        this.isDone = data.equals("X");
    }

    protected boolean validForDate(LocalDate date) {
        return true;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public abstract String serialise();
}