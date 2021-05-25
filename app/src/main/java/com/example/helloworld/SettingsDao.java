package com.example.helloworld;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SettingsDao {
    @Query("SELECT * FROM settingsentity")
    LiveData<List<SettingsEntity>> getAllSettings();

    @Update
    void updateSettings(SettingsEntity... settings);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(SettingsEntity... settings);

    @Delete //to clear settings
    void delete(SettingsEntity settings);
}
