package com.example.bojiejiang.interactivestory.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bojiejiang.interactivestory.R;


public class MainActivity extends Activity {

    private EditText mNameField;
    private Button mStartButton;
    private String mName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameField = (EditText) findViewById(R.id.et_name);
        mStartButton = (Button) findViewById(R.id.btn_start_adventure);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mName = mNameField.getText().toString();
                startStory();
            }
        });

    }

    private void startStory() {
        Intent intent = new Intent(MainActivity.this, StoryActivity.class);
        intent.putExtra(getString(R.string.key_name), mName);
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mNameField.setText("");
    }
}
