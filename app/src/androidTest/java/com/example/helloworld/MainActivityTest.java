package com.example.helloworld;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static org.hamcrest.Matchers.allOf;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void hasTextOnScreen() {
        onView(withId(R.id.textView))
                .check(matches(withText("Peter Torres 4/26/21")));
    }

    @Test
    public void userCanSignUp() throws InterruptedException {
        onView(withId(R.id.nameEditText)).perform(typeText("Diego"));
        onView(withId(R.id.ageEditText)).perform(typeText("12"));
        onView(withId(R.id.occupationEditText)).perform(typeText("Dog"));
        onView(withId(R.id.descriptionEditText)).perform(typeText("Chill"));

        onView(withId(R.id.submitButton)).perform(scrollTo(),(click()));

        onView(allOf(withId(R.id.nameTextView))).check(matches(withText("Diego")));
        onView(allOf(withId(R.id.ageTextView))).check(matches(withText("12")));
        onView(allOf(withId(R.id.occupationTextView))).check(matches(withText("Dog")));
        onView(allOf(withId(R.id.descriptionTextView))).check(matches(withText("Chill")));

    }

    @Test
    public void blankNameCheck() {
        onView(withId(R.id.nameTextView)).perform(typeText(""));
        onView(withId(R.id.submitButton)).perform(scrollTo(),(click()));
        onView(allOf(withId(R.id.nameTextView), hasErrorText("Please enter name!")));
    }
}