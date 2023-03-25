package com.example.brainboost.Courses.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.brainboost.R;
import com.example.brainboost.Tests.fragments.questions;
import com.example.brainboost.Tests.views.tests;

import java.util.Calendar;

public class seeCourses extends AppCompatActivity {
    TextView description;
    ImageButton arrow;
    Button button;
    FrameLayout evaluation;
    final int MAX_LINES=3;
    // Obtener la fecha actual
    final Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_courses);
        description=findViewById(R.id.courseDescription);
        evaluation=findViewById(R.id.evaluation);
        button=findViewById(R.id.makeDate);
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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la fecha actual
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                // Mostrar el DatePickerDialog para seleccionar la fecha
                DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // La fecha seleccionada
                                String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;

                                // Mostrar el TimePickerDialog para seleccionar la hora
                                TimePickerDialog timePickerDialog = new TimePickerDialog(context,
                                        new TimePickerDialog.OnTimeSetListener() {
                                            @Override
                                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                                // La hora seleccionada
                                                String time = hourOfDay + ":" + minute;

                                                // Combinar la fecha y la hora seleccionadas
                                                String datetime = "Tu cita quedo agendada para: "+date + " a las:" + time;

                                                // Mostrar el resultado en un Toast
                                                Toast.makeText(context, datetime, Toast.LENGTH_SHORT).show();
                                            }
                                        }, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), false);
                                timePickerDialog.show();
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
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