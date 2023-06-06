package com.example.a926975;

import androidx.appcompat.app.AppCompatActivity;
import android.content.*;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void beginClickHandler(View view) {
        Intent buttonClick = new Intent(MainActivity.this, story_info.class);
        startActivity(buttonClick);
    }
}