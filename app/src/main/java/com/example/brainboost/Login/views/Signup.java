package com.example.brainboost.Login.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.brainboost.Login.helpers.LoginHelper;
import com.example.brainboost.MainActivity;
import com.example.brainboost.R;

public class Signup extends AppCompatActivity {
    private final LoginHelper helper = new LoginHelper();
    EditText name;
    EditText last_name;
    EditText email;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=findViewById(R.id.name);
        last_name=findViewById(R.id.lastName);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
    }

    public void sendData(View view){
        String emailValue = email.getText().toString();
        String nameValue = name.getText().toString();
        String last_nameValue = last_name.getText().toString();
        String passwordValue = password.getText().toString();
        helper.signUp(this, emailValue, passwordValue, nameValue, last_nameValue);
    }
}