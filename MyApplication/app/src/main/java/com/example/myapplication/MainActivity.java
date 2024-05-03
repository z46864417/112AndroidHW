package com.example.myapplication;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox chk1 = findViewById(R.id.chk1);
        CheckBox chk2 = findViewById(R.id.chk2);
        CheckBox chk3 = findViewById(R.id.chk3);
        CheckBox chk4 = findViewById(R.id.chk4);
        CheckBox chk5 = findViewById(R.id.chk5);
        ImageView output1 = findViewById(R.id.output1);
        ImageView output2 = findViewById(R.id.output2);
        ImageView output3 = findViewById(R.id.output3);
        ImageView output4 = findViewById(R.id.output4);
        ImageView output5 = findViewById(R.id.output5);

        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    output1.setImageResource(R.mipmap.burger);
                } else {
                    output1.setImageResource(0);
                }
            }
        });

        chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    output2.setImageResource(R.mipmap.frenchfry);
                } else {
                    output2.setImageResource(0);
                }
            }
        });

        chk3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    output3.setImageResource(R.mipmap.softdrink);
                } else {
                    output3.setImageResource(0);
                }
            }
        });

        chk4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    output4.setImageResource(R.mipmap.soup);
                } else {
                    output4.setImageResource(0);
                }
            }
        });

        chk5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    output5.setImageResource(R.mipmap.coffee);
                } else {
                    output5.setImageResource(0);
                }
            }
        });


    }
}