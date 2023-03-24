package com.example.brainboost.Courses.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.brainboost.R;

public class seeCourses extends AppCompatActivity {
    TextView description;
    ImageButton arrow;
    final int MAX_LINES=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_courses);
        description=findViewById(R.id.courseDescription);
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
    }


}