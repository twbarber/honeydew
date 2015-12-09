package com.hurdsbrook.honeydew;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tyler on 12/8/15.
 */
public class AddItemFragment extends Fragment {

    private Button mSaveButton;
    private Button mCancelButton;
    private TextView mTaskName;
    private TextView mTaskDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.add_item, container, false);

        mTaskName = (TextView) v.findViewById(R.id.edit_task_name);
        mTaskDescription = (TextView) v.findViewById(R.id.edit_task_description);

        mSaveButton = (Button) v.findViewById(R.id.save_add_button);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task taskToAdd = new Task(mTaskName.getText().toString(), mTaskDescription.getText().toString());
                Toast.makeText(getContext(), taskToAdd.getName(), Toast.LENGTH_LONG).show();
            }
        });

        mCancelButton = (Button) v.findViewById(R.id.cancel_add_button);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }

}
