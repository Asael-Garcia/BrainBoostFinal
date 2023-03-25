package com.example.brainboost.Courses.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.brainboost.R;
import com.example.brainboost.Tests.fragments.questions;
import com.example.brainboost.Tests.views.tests;

public class seeCourses extends AppCompatActivity {
    TextView description;
    ImageButton arrow;
    FrameLayout evaluation;
    final int MAX_LINES=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_courses);
        description=findViewById(R.id.courseDescription);
        evaluation=findViewById(R.id.evaluation);
        Context context= this;
        arrow=findViewById(R.id.arrow);
        description.setMaxLines(MAX_LINES);
        arrow.setOnClickListener(new View.OnClickListener() {
            boolean expanded = false;
            @Override
            public void onClick(View v) {
                expanded = !expanded;
                if (expanded) {
                    description.setMaxLines(Integer.MAX_VALUE);

                } else {
                    description.setMaxLines(MAX_LINES);

                }
            }
        });
        evaluation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, tests.class);
                startActivity(intent);
            }
        });
    }


}