package com.hurdsbrook.honeydew;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by tyler on 12/8/15.
 */
public class Task implements Parcelable {

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

    protected Task(Parcel in) {
        name = in.readString();
        description = in.readString();
        isComplete = in.readByte() != 0;
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

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
        dest.writeString(name);
        dest.writeString(description);
        dest.writeByte((byte) (isComplete ? 1 : 0));
    }
}
