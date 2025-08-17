public class Deadline extends Task {
    private String endTime;

    public Deadline(String description, String endTime) throws EmptyAttributeException {
        super(description);
        if (endTime.isEmpty()) {
            throw new EmptyAttributeException("event", "/by");
        }
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + endTime + ")";
    }
}
