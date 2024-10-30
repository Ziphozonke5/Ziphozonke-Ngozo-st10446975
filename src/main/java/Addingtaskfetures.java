import javax.swing.*;
import java.util.ArrayList;

// Task class
class Task {
    private static int taskCount = 0; // Static counter for task numbers
    private int taskNumber;
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskNumber = taskCount++;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = createTaskID();
        this.taskStatus = taskStatus;
    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    public String createTaskID() {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerDetails.substring(0, 3).toUpperCase();
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus +
               "\nDeveloper Details: " + developerDetails +
               "\nTask Number: " + taskNumber +
               "\nTask Name: " + taskName +
               "\nTask Description: " + taskDescription +
               "\nTask ID: " + taskID +
               "\nDuration: " + taskDuration + " hours";
    }

    public int getTaskDuration() {
        return taskDuration;
    }
}

// Main application class
    public class Addingtaskfetures{
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int totalHours = 0;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        String[] options = {"Add tasks", "Show report", "Coming Soon", "Quit"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0: // Add tasks
                    addTasks();
                    break;
                case 1: // Show report
                    showReport();
                    break;
                case 2: // Coming Soon
                    showComingSoon();
                    break;
                case 3: // Quit
                    JOptionPane.showMessageDialog(null, "Exiting application...");
                    return;
                default:
                    break;
            }
        }
    }

    private static void addTasks() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to enter?"));
        
        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            String taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
            String developerDetails = JOptionPane.showInputDialog("Enter developer details:");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Select task status:",
                    "Task Status", JOptionPane.QUESTION_MESSAGE, null, new String[]{"To Do", "Doing", "Done"}, "To Do");

            Task newTask = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);

            if (newTask.checkTaskDescription()) {
                tasks.add(newTask);
                totalHours += taskDuration;
                JOptionPane.showMessageDialog(null, "Task successfully captured:\n" + newTask.printTaskDetails());
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                i--; // Retry this task
            }
        }

        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
    }

    private static void showReport() {
        StringBuilder report = new StringBuilder("Tasks Report:\n");
        for (Task task : tasks) {
            report.append(task.printTaskDetails()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }

    private static void showComingSoon() {
        JOptionPane.showMessageDialog(null, "New features are coming soon! Stay tuned!");
    }
}
