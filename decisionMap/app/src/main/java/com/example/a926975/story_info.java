package com.example.a926975;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.*;
import android.widget.*;
import java.io.*;

public class story_info extends AppCompatActivity {
    DecisionNode node;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_info);

        InputStream inFile = getResources().openRawResource(R.raw.cw_data);
        BufferedReader csvReader = new BufferedReader(new InputStreamReader(inFile));

        try {
            DecisionMap perec = new DecisionMap(csvReader);
            node = perec.entryPoint();
            getInfo(node);

            final Button buttonOne = findViewById(R.id.firstChoiceButton);
            buttonOne.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    node = node.getChoiceOneNode();
                    getInfo(node);
                }
            });

            final Button buttonTwo = findViewById(R.id.secondChoiceButton);
            buttonTwo.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    node = node.getChoiceTwoNode();
                    getInfo(node);
                }
            });

        } catch (IOException e) {
            exceptionToast(getApplicationContext(), e.getMessage());
        }
    }

    public static void exceptionToast(Context context, String message) {
         Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public void getInfo(DecisionNode node) {
        if (node.getYesID() == -1 && node.getNoID() == -1){
            Intent buttonClick = new Intent(story_info.this, ending_page.class);
            buttonClick.putExtra("pass message", node.getDescription());
            startActivity(buttonClick);
        }
        else {
            TextView storyDesc = (TextView) findViewById(R.id.storyInfo);
            storyDesc.setText(node.getDescription());

            TextView storyQ = (TextView) findViewById(R.id.storyQuestion);
            storyQ.setText(node.getQuestion());

            Button optionOne = (Button) findViewById(R.id.firstChoiceButton);
            optionOne.setText(node.getChoiceOne());

            Button optionTwo = (Button) findViewById(R.id.secondChoiceButton);
            optionTwo.setText(node.getChoiceTwo());
        }
    }
}