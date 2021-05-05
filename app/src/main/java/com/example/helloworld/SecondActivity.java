package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class SecondActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = SecondActivity.class.getSimpleName();
    private String name, age, occupation, description;
    private ImageView profilePicture;
    private Button homeButton;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_profile);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();


        if (b != null) {
            if (b.containsKey(Constants.KEY_NAME)) {
                name = b.getString(Constants.KEY_NAME);
            }
            if (b.containsKey(Constants.KEY_AGE)) {
                age = b.getString((Constants.KEY_AGE));
            }
            if (b.containsKey(Constants.KEY_OCCUPATION)) {
                occupation = b.getString(Constants.KEY_OCCUPATION);
            }
            if (b.containsKey(Constants.KEY_DESCRIPTION)) {
                description = b.getString(Constants.KEY_DESCRIPTION);
            }
        }

        ProfileFragment profileFragment = new ProfileFragment();
        profileFragment.setInfo(new Info(name, age, occupation, description));

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frameLayout, profileFragment, "profileFragment");
        transaction.commit();
        Log.i(TAG, "onCreate()");




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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_profile:
                ProfileFragment fragment = new ProfileFragment();
                fragment.setInfo(new Info(name, age, occupation, description));
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                break;
            case R.id.nav_matches:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new MatchessFragment()).commit();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new SettingsFragment()).commit();
                break;;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public static class Info {
        String name, age, occupation, description;

        Info(String name, String age, String occupation, String description) {
            this.name = name;
            this.age = age;
            this.occupation = occupation;
            this.description = description;
        }
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
