package com.example.brainboost.Login.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.brainboost.Login.helpers.LoginHelper;
import com.example.brainboost.R;




public class Login extends AppCompatActivity {
    private final LoginHelper helper = new LoginHelper();
    EditText email;
    EditText password;
    Button loggin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        loggin=findViewById(R.id.loggin);
        Context context= this;
        loggin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.isLogged(context);

            }
        });



    }
    public void sendData(View view){
        String emailValue = email.getText().toString();
        String passwordValue = password.getText().toString();
        helper.login(this, emailValue, passwordValue);
        Intent intento = new Intent(this, Home.class);
        startActivity(intento);
    }
}