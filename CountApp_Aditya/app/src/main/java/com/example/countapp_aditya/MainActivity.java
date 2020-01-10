package com.example.countapp_aditya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.text1);
    }

    public void count(View view) {
        count++;
        t1.setText(""+count);
    }

    public void toast(View view) {
        Toast.makeText(this, "Hai students", Toast.LENGTH_SHORT).show();
    }
}
