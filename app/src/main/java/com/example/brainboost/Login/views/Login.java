package com.example.brainboost.Login.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.brainboost.Login.helpers.LoginHelper;
import com.example.brainboost.R;


public class Login extends AppCompatActivity {
    private final LoginHelper helper = new LoginHelper();
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);


    }
    public void sendData(View view){
        String emailValue = email.getText().toString();
        helper.login(this, emailValue);
        Toast toast = Toast.makeText(this, "listo, datos enviados", Toast.LENGTH_LONG);
        toast.show();
        Intent intento = new Intent(this, Home.class);
        startActivity(intento);
    }
}