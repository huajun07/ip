public enum Attribute {
    FROM("/from"),
    TO("/to"),
    BY("/by");

    private final String tag;
    Attribute(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }
}
