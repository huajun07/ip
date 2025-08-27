package chirp.io;

public enum Attribute {
    FROM("/from"),
    TO("/to"),
    BY("/by"),
    ON("/on");

    private final String tag;

    Attribute(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }
}
