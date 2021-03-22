package com.severianfw.my_profile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnSignUp = findViewById(R.id.btn_sign_up);
        EditText etEmail = findViewById(R.id.et_email_register);
        EditText etUsername = findViewById(R.id.et_username_register);
        EditText etPassword = findViewById(R.id.et_password_register);
        EditText etConfirmPassword = findViewById(R.id.et_confirm_password_register);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String confPassword = etConfirmPassword.getText().toString();

                if (password.equals(confPassword)) {
                    sharedPreferences = getSharedPreferences("USER_DATA", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("EMAIL", email);
                    editor.putString("USERNAME", username);
                    editor.putString("PASSWORD", password);
                    editor.apply();
                    Toast.makeText(RegisterActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Password not match!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


}