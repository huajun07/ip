public class AddAction extends Action {
    private Task task;

    public AddAction(Command command, String input) throws ChirpException {
        switch (command) {
            case TODO -> {
                // Todo task
                String description = Parser.extractAttribute(input, Command.TODO.getKeyword());
                task = new Todo(description);
            }
            case DEADLINE -> {
                // Deadline task
                String description = Parser.extractAttribute(input, Command.DEADLINE.getKeyword());
                String endTime = Parser.extractAttribute(input, Attribute.BY.getTag());
                task = new Deadline(description, endTime);
            }
            case EVENT -> {
                // Event task
                String description = Parser.extractAttribute(input, Command.EVENT.getKeyword());
                String startTime = Parser.extractAttribute(input, Attribute.FROM.getTag());
                String endTime = Parser.extractAttribute(input, Attribute.TO.getTag());
                task = new Event(description, startTime, endTime);
            }
        }
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        taskList.addTask(task);
        ui.printMessage(" Added task: " + task + "\n" + ui.taskListCount(taskList) + "\n");
    }
}
