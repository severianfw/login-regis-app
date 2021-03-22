package com.severianfw.my_profile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.severianfw.my_profile_app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        mainBinding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = mainBinding.etUsername.getText().toString();
                String password = mainBinding.etPassword.getText().toString();
                sharedPreferences = getSharedPreferences("USER_DATA", MODE_PRIVATE);

                Log.d("username", username);

                if (username.equals(sharedPreferences.getString("USERNAME", "")) && password.equals(sharedPreferences.getString("PASSWORD", ""))) {
                    Bundle bundle = new Bundle();
                    bundle.putString("LOGGED_IN_USERNAME", username);
                    bundle.putString("LOGGED_IN_EMAIL", sharedPreferences.getString("EMAIL", ""));
                    Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Username or Password Incorrect!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainBinding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        setContentView(mainBinding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("pesan", "ini lagi onStart");
    }

}