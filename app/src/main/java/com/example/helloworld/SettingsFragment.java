package com.example.helloworld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class SettingsFragment extends Fragment {

    private TimePicker timePickerReminder;
    private TextView reminderTime;
    private String format = "";
    private Button reminderButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        timePickerReminder = (TimePicker) view.findViewById(R.id.dailyMatchesReminderTimePicker);
        reminderTime = (TextView) view.findViewById(R.id.timeTextView);
        reminderButton = (Button) view.findViewById(R.id.dailyMatchesReminderButton);
        reminderButton.setOnClickListener(v -> {
            int hour = timePickerReminder.getHour();
            int min = timePickerReminder.getMinute();
            if (hour == 0) {
                hour += 12;
                format = "AM";
            } else if (hour == 12) {
                format = "PM";
            } else if (hour > 12) {
                hour -= 12;
                format = "PM";
            } else {
                format = "AM";
            }
            reminderTime.setText(new StringBuilder().append(hour).append(" : ").append(min).append(" ").append(format));
        });

        Spinner distanceSpinner = (Spinner) view.findViewById(R.id.distanceSearchSpinner);
        ArrayAdapter<CharSequence> distanceAdapter = ArrayAdapter.createFromResource(getContext(), R.array.distance_array, android.R.layout.simple_spinner_item);
        distanceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distanceSpinner.setAdapter(distanceAdapter);

        Spinner ageSpinner = (Spinner) view.findViewById(R.id.ageRangeSpinner);
        ArrayAdapter<CharSequence> ageAdapter = ArrayAdapter.createFromResource(getContext(), R.array.age_array, android.R.layout.simple_spinner_item);
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(ageAdapter);

        return view;
    }


}
