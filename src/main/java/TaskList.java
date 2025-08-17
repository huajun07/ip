public class TaskList {

    private static final int MAX_SIZE = 100;
    private Task[] tasks; // List of task descriptions
    private int numOfTasks; // Number of tasks in list


    public TaskList() {
        tasks = new Task[MAX_SIZE];
        numOfTasks = 0;
    }

    /**
     * Adds tasks to task list
     * @param description description of task to be added
     */
    public void addTask(String description) {
        if (numOfTasks == MAX_SIZE) {
            throw new RuntimeException("TaskList Full!");
        }
        tasks[numOfTasks] = new Task(description);
        numOfTasks++;
    }

    /**
     * Marks a task in the task list as done/not done
     * @param idx Index of task to mark (0-indexed)
     * @param isDone Whether to mark the task as done or not done
     */
    public void markTask(int idx, boolean isDone) {
        if (idx < 0 || idx >= numOfTasks) {
            throw new ArrayIndexOutOfBoundsException("TaskList index out of range");
        }
        tasks[idx].setDone(isDone);
    }

    /**
     * Getter function for task in list
     * @param idx Index of task to retrieve (0-indexed)
     * @return Requested task
     */
    public Task getTask(int idx) {
        if (idx < 0 || idx >= numOfTasks) {
            throw new ArrayIndexOutOfBoundsException("TaskList index out of range");
        }
        return tasks[idx];
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
