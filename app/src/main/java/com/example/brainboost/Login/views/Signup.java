package com.example.brainboost.Login.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.brainboost.R;

public class Signup extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
    }

    public void sendData(View view){
        Toast toast = Toast.makeText(this, "listo, datos enviados", Toast.LENGTH_LONG);
        toast.show();
    }
}