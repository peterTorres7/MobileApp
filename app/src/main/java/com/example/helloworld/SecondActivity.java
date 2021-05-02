package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();
    private TextView nameTextView, ageTextView, occupationTextView, descriptionTextView;
    private ImageView profilePicture;
    private Button homeButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ProfileFragment profileFragment = new ProfileFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frameLayout, profileFragment, "profileFragment");
        transaction.commit();
        Log.i(TAG, "onCreate()");

//        homeButton = findViewById(R.id.homeButton);
//        homeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
//
//        profilePicture = findViewById(R.id.profilePicture);
//        nameTextView = findViewById(R.id.nameTextView);
//        ageTextView = findViewById(R.id.ageTextView);
//        occupationTextView = findViewById(R.id.occupationTextView);
//        descriptionTextView = findViewById(R.id.descriptionTextView);
//
//        Intent intent = getIntent();
//        Bundle b = intent.getExtras();
//
//        String age = "12";
//        String name = "Diego";
//        String occupation = "Dog";
//        String description = "Love treats and long walks!";
//
//        if (b != null) {
//            if (b.containsKey(Constants.KEY_NAME)) {
//                name = b.getString(Constants.KEY_NAME);
//            }
//            if (b.containsKey(Constants.KEY_AGE)) {
//                age = b.getString((Constants.KEY_AGE));
//            }
//            if (b.containsKey(Constants.KEY_OCCUPATION)) {
//                occupation = b.getString(Constants.KEY_OCCUPATION);
//            }
//            if (b.containsKey(Constants.KEY_DESCRIPTION)) {
//                description = b.getString(Constants.KEY_DESCRIPTION);
//            }
//        }
//
//        Log.i(TAG, new StringBuilder("Name: ").append(name).toString());
//
//        nameTextView.setText(name);
//        ageTextView.setText(age);
//        occupationTextView.setText(occupation);
//        descriptionTextView.setText(description);

        Log.i(TAG, "onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();;
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
