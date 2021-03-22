package com.severianfw.my_profile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView tvProfile = findViewById(R.id.tv_profile);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String username = bundle.getString("LOGGED_IN_USERNAME");
        tvProfile.setText(username);
    }
}