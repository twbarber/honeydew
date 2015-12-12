package com.hurdsbrook.honeydew;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.List;

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

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {

        private List<Task> mTasks;

        public TaskAdapter(List<Task> tasks) {
            mTasks = tasks;
        }

        @Override
        public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.task_list_item, parent, false);
            return new TaskHolder(view);
        }

        @Override
        public void onBindViewHolder(TaskHolder holder, int position) {
            Task task = mTasks.get(position);
            holder.bindTask(task);
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }

    private class TaskHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView mTitleTextView;
        private Task mTask;

        public TaskHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView)
                    itemView.findViewById(R.id.list_item_task_name_text_view);

        }

        public void bindTask(Task task) {
            mTitleTextView.setText(task.getName());

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),
                    mTask.getName() + " clicked!", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
