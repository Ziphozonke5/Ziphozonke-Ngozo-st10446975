public class TaskTest {
    private String title;
    private String description;
    private String assignee;
    private int duration; // in hours
    private String status;

    public TaskTest(String title, String description, String assignee, int duration, String status) {
        if (duration < 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
        this.title = title;
        this.description = description;
        this.assignee = assignee;
        this.duration = duration;
        this.status = status;
    }

    public boolean checkTaskDescription() {
        return description.length() <= 50; // Valid if <= 50 characters
    }

    public String createTaskID() {
        String shortAssignee = assignee.substring(0, 3).toUpperCase();
        return title.substring(0, 2).toUpperCase() + ":" + duration + ":" + shortAssignee;
    }

    public int getTaskDuration() {
        return duration;
    }
}
