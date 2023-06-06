package com.example.a926975;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ending_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending_page);

        Intent pass = getIntent();
        String message = pass.getStringExtra("pass message");
        TextView tv = (TextView) findViewById(R.id.endingText);
        tv.setText(message);
    }

    public void restartButtonHandler(View view){
        Intent buttonClick = new Intent(ending_page.this, MainActivity.class);
        startActivity(buttonClick);
    }
}