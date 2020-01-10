package com.example.intentapp_aditya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.edit1);
    }

    public void navigate(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    public void browser(View view) {
        String value = et1.getText().toString();
        Uri uri = Uri.parse("http://"+value);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    public void openMaps(View view)
    {
        // The following line helps us to get connected to the actual
        // View On the Screen (xml)
        EditText a = findViewById(R.id.address);
        String address = a.getText().toString();
        // Create an Intent Object
        Intent i = new Intent();
        // set action on intent
        i.setAction(Intent.ACTION_VIEW);
        // Preparing data to open maps with specific address
        Uri data = Uri.parse("geo:0,0?q="+address);
        // set data on intent
        i.setData(data);
        // call the activity that resolves this request
        startActivity(i);
    }
}
