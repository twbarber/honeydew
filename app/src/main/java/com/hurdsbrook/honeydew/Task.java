package com.hurdsbrook.honeydew;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by tyler on 12/8/15.
 */
public class Task {

    private String name;
    private String description;
    private Collection<Task> subtasks;
    private boolean isComplete;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.subtasks = new ArrayList<>();
        this.isComplete = false;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void addSubtask(Task subtaskToAdd) {
        this.subtasks.add(subtaskToAdd);
    }

    public void removeSubtask(Task subtaskToRemove) {
        this.subtasks.remove(subtaskToRemove);
    }

    public void markComplete() {
        this.isComplete = true;
    }

    public void markIncomplete() {
        this.isComplete = false;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public Collection<Task> getSubtasks() {
        return this.subtasks;
    }

    public void clearSubtasks() {
        this.subtasks.clear();
    }

}
