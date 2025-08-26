public class Deadline extends Task {
    private String endTime;

    public Deadline(String description, String endTime) throws ChirpException {
        super(description);
        if (endTime.isEmpty()) {
            throw new ChirpException.EmptyAttributeException("event", Attribute.BY.getTag());
        }
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + endTime + ")";
    }
}
