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
     * @param task task to be added
     */
    private void addTask(Task task) {
        if (numOfTasks == MAX_SIZE) {
            throw new RuntimeException("TaskList Full!");
        }
        tasks[numOfTasks] = task;
        numOfTasks++;
    }

    /**
     * Add todo task to task list
     * @param description task description
     * @return The added task
     */
    public Todo addTodo(String description) throws EmptyAttributeException {
        Todo task = new Todo(description);
        addTask(task);
        return task;
    }

    /**
     * Add deadline task to task list
     * @param description task description
     * @param endTime deadline end
     * @return The added task
     */
    public Deadline addDeadline(String description, String endTime) throws EmptyAttributeException {
        Deadline task = new Deadline(description, endTime);
        addTask(task);
        return task;
    }

    /**
     * Add event task to task list
     * @param description task description
     * @param startTime event start
     * @param endTime event end
     * @return The added task
     */
    public Event addEvent(String description, String startTime, String endTime) throws EmptyAttributeException {
        Event task = new Event(description, startTime, endTime);
        addTask(task);
        return task;
    }

    /**
     * Marks a task in the task list as done/not done
     * @param idx Index of task to mark (0-indexed)
     * @param isDone Whether to mark the task as done or not done
     */
    public void markTask(int idx, boolean isDone) throws TaskListOutOfBoundsException {
        if (idx < 0 || idx >= numOfTasks) {
            throw new TaskListOutOfBoundsException(idx, numOfTasks);
        }
        tasks[idx].setDone(isDone);
    }

    /**
     * Getter function for task in list
     * @param idx Index of task to retrieve (0-indexed)
     * @return Requested task
     */
    public Task getTask(int idx) throws TaskListOutOfBoundsException {
        if (idx < 0 || idx >= numOfTasks) {
            throw new TaskListOutOfBoundsException(idx, numOfTasks);
        }
        return tasks[idx];
    }

    /**
     * Getter function for num of tasks in list
     * @return Num of tasks in list
     */
    public int getNumOfTasks() {
        return numOfTasks;
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
