package com.example.roomdatabase_aditya;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Human.class},version = 1,exportSchema = false)
public abstract class HumanDatabase extends RoomDatabase
{
    public abstract HumanDao humanDao();
}
