package com.example.brainboost.Login.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brainboost.Login.helpers.LoginHelper;
import com.example.brainboost.R;

import org.w3c.dom.Text;

public class OnBoard extends AppCompatActivity {

    //Cosas que vamos a estar intercambiando con el step
    TextView tittle;
    TextView information;
    ImageView imageView;
    Button singUp;
    Button loggin;
    int stepIndex=0;
    LoginHelper loginHelper = new LoginHelper();
    String [] stepImages={"onboarding1.png","onboarding2.png","onboarding3.png"};
    String [] stepTittles={"Varias pruebas de cursos gratuitios","Rapido y facil de aprender","Crea tu propio plan de estudio"};
    String [] stepInformation={"Cursos gratuitos para que encuentres tu camino hacia el aprendizaje",
            "Aprendizaje fácil y rápido en cualquier momento para ayudarte a mejorar varias habilidades",
            "Estudia de acuerdo con el plan de estudio, haz que el estudio sea más interesante."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        tittle=findViewById(R.id.tittle);
        information=findViewById(R.id.information);
        imageView=findViewById(R.id.imageView);
        singUp=findViewById(R.id.button);
        loggin=findViewById(R.id.button2);
        singUp.setVisibility(View.GONE);
        loggin.setVisibility(View.GONE);
        if(loginHelper.isLogged(this)){
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
            finish();
        }
        nextStep();
    }

    public void nextStep(){
        final Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                stepIndex++;
                //cambio de imagenes y texto
                if (stepIndex<stepTittles.length){
                    //cambio de texto
                    tittle.setText(stepTittles[stepIndex]);

                    information.setText(stepInformation[stepIndex]);
                    //cambio de imagenes
                    if(stepIndex==1){
                        imageView.setImageResource(R.drawable.onboarding2);
                    }if(stepIndex==2){
                        imageView.setImageResource(R.drawable.onboarding3);
                        singUp.setVisibility(View.VISIBLE);
                        loggin.setVisibility(View.VISIBLE);
                    }
                    nextStep();
                }
            }
        },2000);
    }

    public void log(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
    public void signUp(View view){
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
        finish();
    }


}