package com.zoople.sharedprefrance2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password,email;
    Button button;
    SharedPreferences sharedPreferences;

    public static final String MYPREFARANCE = "MYpref";
    public static final String NAME = "name";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.edittext1);
        password = findViewById(R.id.edittext2);
        email = findViewById(R.id.edittext3);

        sharedPreferences = getSharedPreferences(MYPREFARANCE, Context.MODE_PRIVATE);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String n = username.getText().toString();
                String pass = password.getText().toString();
                String memail = email.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(NAME,n);
                editor.putString(PASSWORD,pass);
                editor.putString(EMAIL,memail);
                editor.commit();

                Toast.makeText(MainActivity.this, "data succefully saved", Toast.LENGTH_SHORT).show();


            }
        });

        }
    }