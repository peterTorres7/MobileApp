package com.example.helloworld;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;

public class SecondActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);
}
