package com.example.arrayadapterspinner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView displayTextView = findViewById(R.id.display_text);

        String output = getIntent().getStringExtra("output");
        displayTextView.setText(output);
    }
}
