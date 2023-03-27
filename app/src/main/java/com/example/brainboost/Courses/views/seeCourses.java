package com.example.brainboost.Courses.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.brainboost.R;
import com.example.brainboost.Tests.fragments.questions;
import com.example.brainboost.Tests.views.tests;

import java.util.Calendar;

public class seeCourses extends AppCompatActivity {
    TextView description;
    TextView title;
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
        setContentView(R.layout.activity_see_courses);
        description = findViewById(R.id.courseDescription);
        title = findViewById(R.id.courseName);
        status = findViewById(R.id.currentState);
        evaluation = findViewById(R.id.evaluation);
        button = findViewById(R.id.makeDate);
        register = findViewById(R.id.registerCourse);
        Context context = this;
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


        evaluation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, tests.class);
                startActivity(intent);
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creación de la alerta
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Inscribirse a curso")
                        .setMessage("Te inscribiras a: "+title.getText().toString())
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Acciones a realizar al hacer clic en el botón Aceptar
                                status.setText("Inscrito");
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


    /*
    public void createItems(){
        //donde se van a añdir las cosas
        LinearLayout content=findViewById(R.id.contentPanel);
        //fuentes a usar:
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/poppins_medium.ttf");
        Typeface typeface2 = Typeface.createFromAsset(getAssets(), "font/poppins.ttf");


        //margenes y parametros de ancho y alto:
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        //margenes y su conversion a dp
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        float marginLeft = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, left, getResources().getDisplayMetrics());
        float marginRight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, right, getResources().getDisplayMetrics());
        float marginTop = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top, getResources().getDisplayMetrics());
        float marginButton = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottom, getResources().getDisplayMetrics());
        params.setMargins((int) marginLeft,(int)  marginTop,(int)  marginRight,(int) marginButton);//por defecto, se alteran sefun sea necesario


        Context context=this;
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        left = 0;
        right = 0;
        top = 0;
        bottom = 0;
        marginLeft = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, left, getResources().getDisplayMetrics());
        marginRight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, right, getResources().getDisplayMetrics());
        marginTop = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top, getResources().getDisplayMetrics());
        marginButton = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottom, getResources().getDisplayMetrics());
        layoutParams.setMargins((int) marginLeft,(int)  marginTop,(int)  marginRight,(int) marginButton);
        frameLayout.setLayoutParams(layoutParams);



        //CREAR NUMERACIÓN CURSO
        TextView textViewNumber = new TextView(context);
        textViewNumber.setText("Nombre curso");//nombre curso
        //margenes del titulo
        left = 15;
        right = 0;
        top = 0;
        bottom = 0;
        marginLeft = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, left, getResources().getDisplayMetrics());
        marginRight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, right, getResources().getDisplayMetrics());
        marginTop = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top, getResources().getDisplayMetrics());
        marginButton = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottom, getResources().getDisplayMetrics());
        params.setMargins((int) marginLeft,(int)  marginTop,(int)  marginRight,(int) marginButton);//por defecto, se alteran sefun sea necesario
        textViewNumber.setLayoutParams(params);
        textView.setTypeface(typeface);
        textView.setTextColor(Color.parseColor("#1F1F39"));
        textView.setTextSize(14);
        frameLayout.addView(textView);


        // Crear TITULO
        TextView textView = new TextView(context);
        textView.setText("Nombre curso");//nombre curso
        //margenes del titulo
        left = 120;
        right = 0;
        top = 0;
        bottom = 0;
        marginLeft = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, left, getResources().getDisplayMetrics());
        marginRight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, right, getResources().getDisplayMetrics());
        marginTop = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top, getResources().getDisplayMetrics());
        marginButton = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottom, getResources().getDisplayMetrics());
        params.setMargins((int) marginLeft,(int)  marginTop,(int)  marginRight,(int) marginButton);//por defecto, se alteran sefun sea necesario
        textView.setLayoutParams(params);
        textView.setTypeface(typeface);
        textView.setTextColor(Color.parseColor("#1F1F39"));
        textView.setTextSize(14);
        frameLayout.addView(textView);


        // Crear TUTOR
        TextView textView2 = new TextView(context);
        textView2.setText("tutor");//tutor
        //margenes del titulo
        left = 120;
        right = 0;
        top = 30;
        bottom = 0;
        marginLeft = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, left, getResources().getDisplayMetrics());
        marginRight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, right, getResources().getDisplayMetrics());
        marginTop = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top, getResources().getDisplayMetrics());
        marginButton = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottom, getResources().getDisplayMetrics());
        params.setMargins((int) marginLeft,(int)  marginTop,(int)  marginRight,(int) marginButton);//por defecto, se alteran sefun sea necesario
        textView2.setLayoutParams(params);
        textView2.setTypeface(typeface);
        textView2.setTextColor(Color.parseColor("#B8B8D2"));
        textView2.setTextSize(12);
        frameLayout.addView(textView2);


        // Crear CANTIDAD DE CAPITULOS
        TextView textView3 = new TextView(context);
        textView3.setText("capitulos");//cantidad capitulos
        //margenes del titulo
        left = 120;
        right = 0;
        top = 50;
        bottom = 0;
        marginLeft = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, left, getResources().getDisplayMetrics());
        marginRight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, right, getResources().getDisplayMetrics());
        marginTop = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top, getResources().getDisplayMetrics());
        marginButton = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottom, getResources().getDisplayMetrics());
        params.setMargins((int) marginLeft,(int)  marginTop,(int)  marginRight,(int) marginButton);//por defecto, se alteran sefun sea necesario
        textView3.setLayoutParams(params);
        textView3.setTypeface(typeface);
        textView3.setTextColor(Color.parseColor("#FF6905"));
        textView3.setBackground(Drawable.createFromPath("drawable/corner.xml"));
        textView3.setTextSize(10);
        // frameLayout.addView(textView,textView2,textView3);
        frameLayout.addView(textView3);



        //evento para linkear la vista del curso


        //para cambiar de pantalla
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=getContext();
                Intent intento = new Intent(getActivity(), seeCourses.class);
                startActivity(intento);
            }
        });

        //para añadir a favoritos
        frameLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Mostrar el diálogo de alerta
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("¿Quieres añadir este curso a tus favoritos?")
                        .setTitle("Añadir a favoritos")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Se añade a favoritos
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // No pasa nada pq se cancela
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });



        content.addView(frameLayout);
    }*/

}