package com.hurdsbrook.honeydew;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddItemActivity extends Activity {

    private Button mSaveButton;
    private Button mCancelButton;
    private TextView mTaskName;
    private TextView mTaskDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        mTaskName = (TextView) findViewById(R.id.edit_task_name);
        mTaskDescription = (TextView) findViewById(R.id.edit_task_description);

        mSaveButton = (Button) findViewById(R.id.save_add_button);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task taskToAdd = new Task(mTaskName.getText().toString(), mTaskDescription.getText().toString());
                Toast.makeText(v.getContext(), taskToAdd.getName(), Toast.LENGTH_LONG).show();
            }
        });

        mCancelButton = (Button) findViewById(R.id.cancel_add_button);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
