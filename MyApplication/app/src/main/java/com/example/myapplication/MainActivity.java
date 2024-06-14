package com.example.myapplication;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Integer> values = new ArrayList<>();
    private int[] images = {R.mipmap.burger, R.mipmap.frenchfry, R.mipmap.softdrink, R.mipmap.soup, R.mipmap.coffee};
    private ImageView[] outputs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox[] chks = {
                findViewById(R.id.chk1),
                findViewById(R.id.chk2),
                findViewById(R.id.chk3),
                findViewById(R.id.chk4),
                findViewById(R.id.chk5)
        };

        outputs = new ImageView[]{
                findViewById(R.id.output1),
                findViewById(R.id.output2),
                findViewById(R.id.output3),
                findViewById(R.id.output4),
                findViewById(R.id.output5)
        };

        for (int i = 0; i < chks.length; i++) {
            final int index = i;
            chks[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        values.add(index);
                    } else {
                        values.remove(Integer.valueOf(index));
                    }
                    updateImages();
                }
            });
        }
    }

    private void updateImages() {
        for (int i = 0; i < outputs.length; i++) {
            if (i < values.size()) {
                outputs[i].setImageResource(images[values.get(i)]);
            } else {
                outputs[i].setImageResource(0);
            }
        }
    }
}