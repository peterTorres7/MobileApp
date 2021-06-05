package com.example.helloworld;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class SettingsFragmentTest {
    @Rule
    public ActivityScenarioRule activityScenarioRule
            = new ActivityScenarioRule<>(SecondActivity.class);

//    @Test
//    public void checkReminderMessage() {
//        onView(withId(R.id.timeSelectionReminder))
//                .check(matches(withText("Please pick a daily matches reminder time below:")));
//    }
}
