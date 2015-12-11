package com.hurdsbrook.honeydew;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Collection;

/**
 * Fragment used to display list of Tasks.
 */
public class TaskListFragment extends Fragment {

    private Collection<Task> mTasks;

    private final String TASK_TO_ADD = "RETURNED_TASK";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_task_list, container, false);
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            Task taskToToast = bundle.getParcelable(TASK_TO_ADD);
            Toast.makeText(getContext(), taskToToast.getName(), Toast.LENGTH_SHORT).show();
        }
        return v;
    }
}
