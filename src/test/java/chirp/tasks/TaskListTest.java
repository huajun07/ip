package chirp.tasks;

import chirp.exceptions.ChirpException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskListTest {
    @Test
    public void taskAdditionTest() throws ChirpException {
        TaskList taskList = new TaskList();
        taskList.addTask(new Todo("Test1"));
        taskList.addTask(new Todo("Test2"));
        taskList.addTask(new Todo("Test3"));
        assertEquals(3, taskList.getNumOfTasks());
        assertEquals("[T][ ] Test1", taskList.getTask(0).toString());
        assertEquals("[T][ ] Test3", taskList.getTask(2).toString());
    }

    @Test
    public void taskMarkingTest() throws ChirpException {
        TaskList taskList = new TaskList();
        taskList.addTask(new Todo("Test1"));
        taskList.markTask(0, true);
        assertEquals("[T][X] Test1", taskList.getTask(0).toString());
        taskList.markTask(0, false);
        assertEquals("[T][ ] Test1", taskList.getTask(0).toString());
        assertThrows(ChirpException.TaskListOutOfBoundsException.class, () -> {
            taskList.markTask(-1, false);
        });
        assertThrows(ChirpException.TaskListOutOfBoundsException.class, () -> {
            taskList.markTask(1, false);
        });
    }

    @Test
    public void taskDeletionTest() throws ChirpException {
        TaskList taskList = new TaskList();
        taskList.addTask(new Todo("Test1"));
        taskList.addTask(new Todo("Test2"));
        taskList.addTask(new Todo("Test3"));
        assertEquals(3, taskList.getNumOfTasks());
        taskList.deleteTask(1);
        assertEquals(2, taskList.getNumOfTasks());
        assertEquals("[T][ ] Test1", taskList.getTask(0).toString());
        assertEquals("[T][ ] Test3", taskList.getTask(1).toString());
        assertThrows(ChirpException.TaskListOutOfBoundsException.class, () -> {
            taskList.deleteTask(-1);
        });
        assertThrows(ChirpException.TaskListOutOfBoundsException.class, () -> {
            taskList.deleteTask(2);
        });
    }
}
