import java.time.LocalDate;
import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> tasks; // List of task descriptions


    public TaskList() {
        tasks = new ArrayList<Task>();
    }

    /**
     * Adds tasks to task list
     * @param task task to be added
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Add todo task to task list
     * @param description task description
     * @return The added task
     */
    public Todo addTodo(String description) throws ChirpException {
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
    public Deadline addDeadline(String description, String endTime) throws ChirpException {
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
    public Event addEvent(String description, String startTime, String endTime) throws ChirpException {
        Event task = new Event(description, startTime, endTime);
        addTask(task);
        return task;
    }

    public Task deleteTask(int idx) throws ChirpException {
        checkValidIdx(idx);
        return tasks.remove(idx);
    }

    /**
     * Marks a task in the task list as done/not done
     * @param idx Index of task to mark (0-indexed)
     * @param isDone Whether to mark the task as done or not done
     */
    public void markTask(int idx, boolean isDone) throws ChirpException {
        checkValidIdx(idx);
        tasks.get(idx).setDone(isDone);
    }

    /**
     * Getter function for task in list
     * @param idx Index of task to retrieve (0-indexed)
     * @return Requested task
     */
    public Task getTask(int idx) throws ChirpException {
        checkValidIdx(idx);
        return tasks.get(idx);
    }

    /**
     * Getter function for num of tasks in list
     * @return Num of tasks in list
     */
    public int getNumOfTasks() {
        return tasks.size();
    }

    /**
     * Display task list
     */
    public void display(LocalDate date) {
        for (int i = 0; i < getNumOfTasks(); i++) {
            if (tasks.get(i).validForDate(date)) {
                System.out.println((i+1) + ". " + tasks.get(i));
            }
        }
    }

    private void checkValidIdx(int idx) throws ChirpException {
        if (idx < 0 || idx >= getNumOfTasks()) {
            throw new ChirpException.TaskListOutOfBoundsException(idx, getNumOfTasks());
        }
    }
}
