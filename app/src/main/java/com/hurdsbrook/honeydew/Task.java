package com.hurdsbrook.honeydew;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *  Task class used for populating task lists.
 */
public class Task implements Parcelable {

    private String name;
    private String description;
    private ArrayList<Task> subtasks;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeList(this.subtasks);
        dest.writeByte(isComplete ? (byte) 1 : (byte) 0);
    }

    protected Task(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.subtasks = new ArrayList<>();
        in.readList(this.subtasks, List.class.getClassLoader());
        this.isComplete = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>() {
        public Task createFromParcel(Parcel source) {
            return new Task(source);
        }

        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
}
