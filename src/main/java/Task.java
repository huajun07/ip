public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) throws ChirpException {
        if (description.isEmpty()) {
            throw new ChirpException.EmptyAttributeException("basic", "description");
        }
        this.description = description;
        this.isDone = false;
    }

    private String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}