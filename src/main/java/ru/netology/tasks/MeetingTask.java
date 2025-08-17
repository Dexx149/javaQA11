package ru.netology.tasks;

public class MeetingTask extends Task {
    String topic;
    String project;
    String start;

    public MeetingTask(int id, String topic, String project, String start) {
        super(id);
        this.topic = topic;
        this.project = project;
        this.start = start;
    }

    public String getTopic() {
        return topic;
    }

    public String getStart() {
        return start;
    }

    public String getProject() {
        return project;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }
}

