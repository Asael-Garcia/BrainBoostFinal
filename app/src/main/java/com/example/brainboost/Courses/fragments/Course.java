package com.example.brainboost.Courses.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.brainboost.Courses.views.CourseDetails;
import com.example.brainboost.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Course extends Fragment {
    TextView titleText;
    TextView authorText;
    String id;
    TextView dateText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        Bundle bundle = getArguments();
        titleText = view.findViewById(R.id.name);
        authorText = view.findViewById(R.id.teacher);
        dateText = view.findViewById(R.id.date);
        if(bundle != null) {
            String title = bundle.getString("title");
            String author = bundle.getString("author");
            String date = bundle.getString("date");
            Date created = null;
            try {
                created = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse((date));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            id = bundle.getString("id");
            titleText.setText(title);
            authorText.setText(author);
            dateText.setText(new SimpleDateFormat("dd-MM-YYYY").format(created));
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CourseDetails.class);
                intent.putExtra("course_id", id);
                Log.e("id", id);
                startActivity(intent);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
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
        return view;
    }
}