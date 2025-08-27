package chirp.tasks;
import java.time.LocalDate;
import java.util.ArrayList;

import chirp.exceptions.ChirpException;

public class TaskList {

    private ArrayList<Task> tasks; // List of task descriptions

    /**
     * Creates a task list object to manage list of tasks
     */
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
     * @return Human-readable string of list of task objects
     */
    public String displayStr(LocalDate date) {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < getNumOfTasks(); i++) {
            if (tasks.get(i).validForDate(date)) {
                data.append(String.format("%d. %s\n", i + 1, tasks.get(i)));
            }
        }
        return data.toString();
    }

    private void checkValidIdx(int idx) throws ChirpException {
        if (idx < 0 || idx >= getNumOfTasks()) {
            throw new ChirpException.TaskListOutOfBoundsException(idx, getNumOfTasks());
        }
    }
}
