import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.nio.file.StandardOpenOption;

public class FileManager {
    private final Path filePath;

    public FileManager(String filePathStr) throws IOException {
        filePath = Paths.get(filePathStr);
        if (Files.notExists(filePath)) {
            createFile();
        }
    }

    private void createFile() throws IOException {
        // Make sure parent directories exist
        Files.createDirectories(filePath.getParent());
        Files.createFile(filePath);
    }

    private String serialiseTasks(TaskList taskList) throws ChirpException {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < taskList.getNumOfTasks(); i++) {
            data.append(taskList.getTask(i).serialise());
            data.append('\n');
        }
        return data.toString();
    }

    private Task deserialiseTask(String data) throws ChirpException {
        if (data.isEmpty()) {
            throw new ChirpException.CorruptedFile("Empty task data!");
        }
        switch (data.substring(0, 1)) {
            case Deadline.tag -> {
                return Deadline.deserialise(data);
            }
            case Event.tag -> {
                return Event.deserialise(data);
            }
            case Todo.tag -> {
                return Todo.deserialise(data);
            }
        }
        throw new ChirpException.CorruptedFile("Invalid Task Tag!");
    }

    public void saveTasks(TaskList taskList) throws IOException, ChirpException {
        String data = serialiseTasks(taskList);
        Files.write(filePath, data.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
    }

    public TaskList loadTasks() throws ChirpException, IOException {
        TaskList taskList = new TaskList();
        BufferedReader reader = Files.newBufferedReader(filePath);
        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.isEmpty()) {
                taskList.addTask(deserialiseTask(line));
            }
        }
        return taskList;
    }
}
