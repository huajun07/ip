public class Event extends Task {
    public static final String tag = "E";
    private String startTime;
    private String endTime;

    public Event(String description, String startTime, String endTime) throws ChirpException {
        super(description);
        if (startTime.isEmpty()) {
            throw new ChirpException.EmptyAttributeException("event", Attribute.FROM.getTag());
        }
        if (endTime.isEmpty()) {
            throw new ChirpException.EmptyAttributeException("event", Attribute.TO.getTag());
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static Event deserialise(String data) throws ChirpException {
        String[] fields = deserialiseFields(data, tag, 5);
        Event task = new Event(fields[2], fields[3], fields[4]);
        task.setDone(fields[1]);
        return task;
    }

    @Override
    public String serialise() {
        return String.format("%s|%s|%s|%s|%s", tag, isDone ? "X" : "O", description, startTime, endTime);
    }

    @Override
    public String toString() {
        return String.format("[%s]%s (from: %s to: %s)", tag, super.toString(), startTime, endTime);
    }
}
