package com.hurdsbrook.honeydew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Activity to add new Tasks to your task list.
 */
public class AddTaskActivity extends AppCompatActivity {

    private Button mSaveButton;
    private Button mCancelButton;
    private TextView mTaskName;
    private TextView mTaskDescription;

    private final String RETURNED_TASK = "RETURNED_TASK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.item_add_toolbar);
        setSupportActionBar(myToolbar);

        mTaskName = (TextView) findViewById(R.id.edit_task_name);
        mTaskDescription = (TextView) findViewById(R.id.edit_task_description);

        mSaveButton = (Button) findViewById(R.id.save_add_button);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task taskToReturn =
                        new Task(mTaskName.getText().toString(), mTaskDescription.getText().toString());
                Intent resultIntent = new Intent();
                resultIntent.putExtra(RETURNED_TASK, taskToReturn);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        mCancelButton = (Button) findViewById(R.id.cancel_add_button);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
     public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
     }

}
