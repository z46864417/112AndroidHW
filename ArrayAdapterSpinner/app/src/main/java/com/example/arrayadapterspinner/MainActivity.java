package com.example.arrayadapterspinner;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner chioceSpinner;
    private ListView listView;
    private TextView lblOutput;
    private ArrayAdapter<CharSequence> listAdapter;
    private String selectedMainCourse = "";
    private String selectedSideDish = "";
    private String selectedDrink = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chioceSpinner = findViewById(R.id.chioce);
        listView = findViewById(R.id.listview);
        lblOutput = findViewById(R.id.lblOutput);

        chioceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        listAdapter = ArrayAdapter.createFromResource(MainActivity.this,
                                R.array.Main_Course, android.R.layout.simple_list_item_1);
                        break;
                    case 1:
                        listAdapter = ArrayAdapter.createFromResource(MainActivity.this,
                                R.array.Side_Dish, android.R.layout.simple_list_item_1);
                        break;
                    case 2:
                        listAdapter = ArrayAdapter.createFromResource(MainActivity.this,
                                R.array.Drink, android.R.layout.simple_list_item_1);
                        break;
                }
                listView.setAdapter(listAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem = (String) parent.getItemAtPosition(position);
                        switch (chioceSpinner.getSelectedItemPosition()) {
                            case 0:
                                selectedMainCourse = selectedItem;
                                break;
                            case 1:
                                selectedSideDish = selectedItem;
                                break;
                            case 2:
                                selectedDrink = selectedItem;
                                break;
                        }
                        updateOutputLabel();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sent) {
            Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
            intent.putExtra("output", lblOutput.getText().toString());
            startActivity(intent);
            return true;
        } else if (id == R.id.cannel) {
            selectedMainCourse = "";
            selectedSideDish = "";
            selectedDrink = "";
            lblOutput.setText("");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateOutputLabel() {
        String output = "主餐: " + selectedMainCourse + "\n" +
                "副餐: " + selectedSideDish + "\n" +
                "飲料: " + selectedDrink;
        lblOutput.setText(output);
    }
}
