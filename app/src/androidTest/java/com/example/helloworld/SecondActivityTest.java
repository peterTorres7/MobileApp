package com.example.helloworld;

import android.view.Gravity;

import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.NavigationViewActions;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class SecondActivityTest {
    @Rule
    public ActivityScenarioRule<SecondActivity> activityScenarioRule
            = new ActivityScenarioRule<>(SecondActivity.class);

    @Test
    public void profileDrawerCheck() {
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))).perform(DrawerActions.open());
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_profile));
    }

    @Test
    public void matchesDrawerCheck() {
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))).perform(DrawerActions.open());
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_matches));

        onView(withId(R.id.your_matches)).check(matches(withText("Here are your matches!")));
    }

    @Test
    public void settingsDrawerCheck() {
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))).perform(DrawerActions.open());
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_settings));

        onView(withId(R.id.timeSelectionReminder)).check(matches(withText("Please pick a daily matches reminder time below:")));
        onView(withId(R.id.dailyMatchesReminderTimePicker)).perform(PickerActions.setTime(5, 30));

        onView(withId(R.id.dailyMatchesReminderButton)).check((matches(withText("Set Reminder!"))));
        onView(withId(R.id.yourReminderTimeIs)).check(matches(withText("Your reminder time is:")));

        onView(withId(R.id.maximumDistanceTextView)).check(matches(withText("Please select maximum distance:")));
        onView(withId(R.id.distanceSearchSpinner)).perform(scrollTo(), click());
        onView(withText("5 Miles")).perform(click());

        onView(withId(R.id.genderTextView)).check(matches(withText("Please select gender:")));
        onView(withId(R.id.radioMale)).perform(scrollTo(), click());

        onView(withId(R.id.privacyTextView)).check(matches(withText("Please select your privacy:")));
        onView(withId(R.id.privacyCheckBox)).perform(scrollTo(), click());

        onView(withId(R.id.ageRangeTextView)).check(matches(withText("Please select interested age range:")));
        onView(withId(R.id.ageRangeSpinner)).perform(scrollTo(), click());
        onView(withText("18 - 25")).perform(click());
    }

}
