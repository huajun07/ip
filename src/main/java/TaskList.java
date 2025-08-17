public class TaskList {

    private static final int MAX_SIZE = 100;
    private String[] tasks; // List of task descriptions
    private int numOfTasks; // Number of tasks in list

    public TaskList() {
        tasks = new String[MAX_SIZE];
        numOfTasks = 0;
    }

    /**
     * Adds tasks to task list
     * @param task description of task to be added
     */
    public void addTasks(String task) {
        if (numOfTasks == MAX_SIZE) {
            throw new RuntimeException("TaskList Full!");
        }
        tasks[numOfTasks] = task;
        numOfTasks++;
    }

    /**
     * Display task list
     */
    public void display() {
        for (int i = 0; i < numOfTasks; i++) {
            System.out.println((i+1) + ". " + tasks[i]);
        }
    }
}
