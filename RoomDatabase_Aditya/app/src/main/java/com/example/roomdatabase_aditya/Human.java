package com.example.roomdatabase_aditya;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "human")
public class Human
{
    @PrimaryKey(autoGenerate = true)
    int person_id;
    /*@ColumnInfo(name = "Whatever")*/
    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getPerson_id() {
        return person_id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
