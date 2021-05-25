package com.example.helloworld;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {SettingsEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SettingsDao settingsDao();
}
