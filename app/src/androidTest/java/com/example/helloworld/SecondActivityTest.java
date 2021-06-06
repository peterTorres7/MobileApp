package com.example.helloworld;

import android.view.Gravity;

import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.NavigationViewActions;
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
    }

    @Test
    public void settingsDrawerCheck() {
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))).perform(DrawerActions.open());
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_settings));
        onView(allOf(withId(R.id.dailyMatchesReminderButton))).check((matches(withText("Set Reminder!"))));
        onView(withId(R.id.timeSelectionReminder)).check(matches(withText("Please pick a daily matches reminder time below:")));

        onView(withId(R.id.distanceSearchSpinner)).perform(scrollTo(), click());
        onView(withText("5 Miles")).perform(click());
        onView(withId(R.id.distanceSearchSpinner)).perform(scrollTo(), click());
        onView(withText("10 Miles")).perform(click());
        onView(withId(R.id.distanceSearchSpinner)).perform(scrollTo(), click());
        onView(withText("15 Miles")).perform(click());
        onView(withId(R.id.distanceSearchSpinner)).perform(scrollTo(), click());
        onView(withText("20 Miles")).perform(click());
        onView(withId(R.id.distanceSearchSpinner)).perform(scrollTo(), click());
        onView(withText("Over 20 Miles")).perform(click());

        onView(withId(R.id.ageRangeSpinner)).perform(scrollTo(), click());
        onView(withText("18 - 25")).perform(click());
        onView(withId(R.id.ageRangeSpinner)).perform(scrollTo(), click());
        onView(withText("25 - 30")).perform(click());
        onView(withId(R.id.ageRangeSpinner)).perform(scrollTo(), click());
        onView(withText("30 - 35")).perform(click());
        onView(withId(R.id.ageRangeSpinner)).perform(scrollTo(), click());
        onView(withText("35 - 40")).perform(click());
        onView(withId(R.id.ageRangeSpinner)).perform(scrollTo(), click());
        onView(withText("40 - 45")).perform(click());
        onView(withId(R.id.ageRangeSpinner)).perform(scrollTo(), click());
        onView(withText("45 - 50")).perform(click());
        onView(withId(R.id.ageRangeSpinner)).perform(scrollTo(), click());
        onView(withText("Over 50")).perform(click());
    }

}
