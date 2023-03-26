package com.example.brainboost.Tests.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.brainboost.R;
import com.example.brainboost.Tests.fragments.questions;

public class tests extends AppCompatActivity {


    questions FragmentQuestions= new questions();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        //carga fragmento de las preguntas en fa
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,FragmentQuestions);
        transaction.commit();
    }
}