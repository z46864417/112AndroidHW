package com.example.a315homework;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void button_Click(View view){
        EditText email = (EditText) findViewById(R.id.txtEmail);
        String Email = email.getText().toString();
        EditText password = (EditText) findViewById(R.id.txtPassword);
        String Password = password.getText().toString();
        TextView output_email = (TextView) findViewById(R.id.lblOutputEmail);
        output_email.setText("電子信箱為:"+Email);
        TextView output_password = (TextView) findViewById(R.id.lblOutputPassword);
        output_password.setText("密碼為:"+Password);
    }
}
