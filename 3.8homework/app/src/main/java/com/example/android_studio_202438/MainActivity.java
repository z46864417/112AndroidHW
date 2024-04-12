package com.example.android_studio_202438;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PictureInPictureUiState;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void button_click(View view){
        int count;
        TextView output = (TextView) findViewById(R.id.textView);
        count = Integer.parseInt(output.getText().toString());
        count++;
        output.setText(Integer.toString(count));
    }

    public void button2_click(View view){
        TextView output = (TextView) findViewById(R.id.textView);
        output.setText(R.string.ini_value);
    }

    public void button3_click(View view){
        int count;
        TextView output = (TextView) findViewById(R.id.textView);
        count = Integer.parseInt(output.getText().toString());
        count--;
        output.setText(Integer.toString(count));
    }

}