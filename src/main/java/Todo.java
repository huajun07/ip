public class Todo extends Task {

    public Todo(String description) throws EmptyAttributeException {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
