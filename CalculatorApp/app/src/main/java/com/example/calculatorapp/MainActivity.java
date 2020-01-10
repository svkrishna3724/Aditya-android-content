package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.edit1);
        e2=findViewById(R.id.edit2);
        t1=findViewById(R.id.text1);
    }

    public void plus(View view) {
        int a,b,c;
        a=Integer.parseInt(e1.getText().toString());
        b=Integer.parseInt(e2.getText().toString());
        c=a+b;
        t1.setText(""+c);
    }

    public void minus(View view) {
        int a,b,c;
        a=Integer.parseInt(e1.getText().toString());
        b=Integer.parseInt(e2.getText().toString());
        c=a-b;
        t1.setText(""+c);
    }

    public void multi(View view) {
        int a,b,c;
        a=Integer.parseInt(e1.getText().toString());
        b=Integer.parseInt(e2.getText().toString());
        c=a*b;
        t1.setText(""+c);
    }

    public void division(View view) {
        int a,b,c;
        a=Integer.parseInt(e1.getText().toString());
        b=Integer.parseInt(e2.getText().toString());
        c=a/b;
        t1.setText(""+c);
    }
}
