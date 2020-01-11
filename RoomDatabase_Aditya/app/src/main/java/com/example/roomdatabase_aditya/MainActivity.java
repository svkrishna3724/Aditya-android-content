package com.example.roomdatabase_aditya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText name,age;
    TextView textView;
    HumanDatabase hd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name1);
        age = findViewById(R.id.age1);
        textView = findViewById(R.id.text1);
        hd = Room.databaseBuilder(this,HumanDatabase.class,"mydb")
                .allowMainThreadQueries()
                .build();
    }

    public void save(View view) {
        String str_name=name.getText().toString();
        int a = Integer.parseInt(age.getText().toString());
        Human h = new Human(str_name,a);
        hd.humanDao().insert(h);
        Toast.makeText(this, "Insertion is successful", Toast.LENGTH_SHORT).show();
        getData();
    }

    private void getData() {
        List<Human> list = hd.humanDao().getall();
        textView.setText("");
        for(int i = 0; i<list.size();i++){
            textView.append("Id: "+list.get(i).getPerson_id()+"\n");
            textView.append("Name: "+list.get(i).getName()+"\n");
            textView.append("Age: "+list.get(i).getAge()+"\n");
            textView.append("____________________________\n");
        }
    }

}
