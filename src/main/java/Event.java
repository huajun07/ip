public class Event extends Task {
    private String startTime;
    private String endTime;

    public Event(String description, String startTime, String endTime) throws EmptyAttributeException {
        super(description);
        if (startTime.isEmpty()) {
            throw new EmptyAttributeException("event", "/from");
        }
        if (endTime.isEmpty()) {
            throw new EmptyAttributeException("event", "/to");
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + startTime + " to: " + endTime + ")";
    }
}
