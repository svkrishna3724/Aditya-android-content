package com.example.inputcontrollers_aditya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ToggleButton tg;
    RadioGroup rg;
    RadioButton rb1,rb2;
    ProgressBar progressBar;
    int progress=0;
    TextView textView;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text1);
        tg = findViewById(R.id.tg1);
        rg = findViewById(R.id.rg1);
        rb1=findViewById(R.id.rb1);
        rb2 =findViewById(R.id.rb2);
        spinner = findViewById(R.id.spinner1);
        progressBar =findViewById(R.id.prog1);
        final ArrayList<String> week = new ArrayList<>();
        week.add("Sunday");
        week.add("Monday");
        week.add("Tuesday");
        week.add("Thursday");
        week.add("Friday");
        week.add("Saturday");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,week);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You Selected"+week.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        Toast.makeText(MainActivity.this, "Selected Male", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb2:
                        Toast.makeText(MainActivity.this, "Selected Female", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        tg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tg.isChecked()){
                    Toast.makeText(MainActivity.this, "On", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void submit(View view) {
        Toast.makeText(this, "hai Friends", Toast.LENGTH_LONG).show();
    }


    public void prog(View view) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               if(progressBar.getProgress()<100){
                   progressBar.setProgress(progress);
                   progress++;
                   handler.postDelayed(this,100);
                   textView.setText("Wait....");

               }else{
                   textView.setText("Finished");
               }
            }
        },100);

    }
}
