package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Constraints;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText nameEditText, ageEditText, descriptionEditText, occupationEditText;
    private Button submitButton;
    private TextView textView;
    private  DatePickerDialog datepicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        birthdayEditText = findViewById(R.id.birthdayEditText);
//        birthdayEditText.setInputType(InputType.TYPE_NULL);
//        birthdayEditText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Calendar calendar = Calendar.getInstance();
//                int day = calendar.get(Calendar.DAY_OF_MONTH);
//                int month = calendar.get(Calendar.MONTH);
//                int year = calendar.get(Calendar.YEAR);
//
//                datepicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                        birthdayEditText.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
//                    }
//                }, year, month, day);
//                datepicker.show();
//
//
//
//            }
//        });


//        // age validation
//        String birthday = birthdayEditText.getText().toString();
//
//        private boolean validateAge(EditText age) {
//            String ageInput = birthdayEditText.getText().toString().trim();
//            if (age <= 18) {
//                Toast.makeText(this, "Valid age!", Toast.LENGTH_SHORT).show();
//                return true;
//            } else {
//                Toast.makeText(this, "Invalid username!", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        }

        Log.i(TAG, "onCreate()");
    }

//    // Email validation
//    private boolean validateEmail(EditText email) {
//        String emailInput = email.getText().toString().trim();
//        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
//            Toast.makeText(this, "Valid email!", Toast.LENGTH_SHORT).show();
//            return true;
//        } else {
//            Toast.makeText(this, "Invalid email!", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//    }


    public void goToSecondActivity(View view) {

        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        occupationEditText = findViewById((R.id.occupationEditText));
        submitButton = findViewById(R.id.submitButton);
        textView = findViewById(R.id.textView);


        if (nameEditText.getText().toString().trim().isEmpty()) {
            nameEditText.setError("Please enter name!");
            return;
        }
        if (ageEditText.getText().toString().trim().isEmpty()) {
            ageEditText.setError("Please enter age!");
            return;
        }
        if (occupationEditText.getText().toString().trim().isEmpty()) {
            occupationEditText.setError("Please enter occupation!");
            return;
        }
        if (descriptionEditText.getText().toString().trim().isEmpty()) {
            descriptionEditText.setError("Please enter description!");
            return;
        }

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(Constants.KEY_NAME, nameEditText.getText().toString());
        intent.putExtra(Constants.KEY_AGE, ageEditText.getText().toString());
        intent.putExtra(Constants.KEY_OCCUPATION, occupationEditText.getText().toString());
        intent.putExtra(Constants.KEY_DESCRIPTION, descriptionEditText.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
        Log.i(TAG, "onRestart()");
    }

    @Override
    protected  void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(TAG, "onRestoreInstanceState()");
        if (savedInstanceState.containsKey(Constants.KEY_NAME)) {
            textView.setText((String)savedInstanceState.get(Constants.KEY_NAME));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "onSaveInstanceState()");
        outState.putString(Constants.KEY_NAME, textView.getText().toString());
        outState.putString(Constants.KEY_BUTTON_TXT, submitButton.getText().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }
}