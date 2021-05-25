package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SettingsEntity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int settingsId;

    @ColumnInfo(name = "daily_matches_reminder_time")
    private int dailyMatchesReminderTime;

    @ColumnInfo(name = "maximum_distance_search")
    private int maximumDistanceSearch;

    @ColumnInfo(name = "gender")
    private String gender;

    @ColumnInfo(name = "private_public_account")
    private boolean privatePublicAccount;

    @ColumnInfo(name = "interested_age_range")
    private int interested_age_range;

    @NonNull
    public int getSettingsId() {
        return settingsId;
    }

    public void setSettingsId(@NonNull int settingsId) {
        this.settingsId = settingsId;
    }

    public int getDailyMatchesReminderTime() {
        return dailyMatchesReminderTime;
    }

    public void setDailyMatchesReminderTime(int dailyMatchesReminderTime) {
        this.dailyMatchesReminderTime = dailyMatchesReminderTime;
    }

    public int getMaximumDistanceSearch() {
        return maximumDistanceSearch;
    }

    public void setMaximumDistanceSearch(int maximumDistanceSearch) {
        this.maximumDistanceSearch = maximumDistanceSearch;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isPrivatePublicAccount() {
        return privatePublicAccount;
    }

    public void setPrivatePublicAccount(boolean privatePublicAccount) {
        this.privatePublicAccount = privatePublicAccount;
    }

    public int getInterested_age_range() {
        return interested_age_range;
    }

    public void setInterested_age_range(int interested_age_range) {
        this.interested_age_range = interested_age_range;
    }
}
