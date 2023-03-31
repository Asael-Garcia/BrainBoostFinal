package com.example.brainboost.Courses.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.brainboost.Courses.fragments.Lesson;
import com.example.brainboost.Login.helpers.interfaces.CourseData;
import com.example.brainboost.Login.helpers.interfaces.FetchCallback;
import com.example.brainboost.Login.helpers.HomeHelper;
import com.example.brainboost.Login.helpers.interfaces.LessonsData;
import com.example.brainboost.Login.helpers.requests.HomeRequests;
import com.example.brainboost.R;

import java.util.Calendar;

public class CourseDetails extends AppCompatActivity {
    TextView description;
    TextView title;
    TextView course_name2;
    TextView status;
    ImageButton arrow;
    Button button;
    Button register;
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
        setContentView(R.layout.activity_course_details);
        description = findViewById(R.id.courseDescription);
        title = findViewById(R.id.courseName);
        status = findViewById(R.id.currentState);
//        evaluation = findViewById(R.id.evaluation);
        button = findViewById(R.id.makeDate);
        register = findViewById(R.id.registerCourse);
        course_name2 = findViewById(R.id.course_name2);
        Context context = this;
        Intent intent = getIntent();
        String id = intent.getStringExtra("course_id");
        HomeHelper homeHelper = new HomeHelper();
        homeHelper.getCourseById(this, id, new FetchCallback<HomeRequests.GetCourseByIdResponse>() {
            @Override
            public void onSuccess(HomeRequests.GetCourseByIdResponse response) {
                course_name2.setText(response.data.name);
                title.setText(response.data.name);
                Log.e("suscrito", Boolean.toString(response.isInCourse));
                if(response.isInCourse){
                    status.setText("Inscrito");
                }
                else {
                    status.setText("No inscrito");
                }
//                description.setText(response.);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                int index = 1;
                for(LessonsData lesson: response.data.Lessons){
                    Bundle bundle = new Bundle();
                    bundle.putString("title", lesson.title);
                    bundle.putInt("number", index);
                    bundle.putString("link", lesson.link);
                    fragmentTransaction.add(R.id.fragmentContainerView, Lesson.class, bundle);
                    index ++;

                }
                fragmentTransaction.commit();

                if(response.isInCourse){
                    Log.e("in_course", Boolean.toString(response.isInCourse));
                    register.setVisibility(View.INVISIBLE);
                }
            }
        });
        arrow = findViewById(R.id.arrow);
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
                                                String datetime = "Tu cita quedo agendada para: " + date + " a las:" + time;

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


//        evaluation.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, tests.class);
//                startActivity(intent);
//            }
//        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creación de la alerta
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Inscribirse a curso")
                        .setMessage("Te inscribiras a: "+title.getText().toString())
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id_a) {
                                // Acciones a realizar al hacer clic en el botón Aceptar
                                homeHelper.subscribe(String.valueOf(id), homeHelper.getUserId(context), new FetchCallback<String>() {
                                    @Override
                                    public void onSuccess(String response) {
                                        status.setText("Inscrito");
                                        register.setVisibility(View.GONE);
                                    }
                                });

                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Acciones a realizar al hacer clic en el botón Cancelar
                            }
                        });

                // Mostrando la alerta
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

    }


}