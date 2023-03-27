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

import com.example.brainboost.Courses.views.seeCourses;
import com.example.brainboost.R;

public class Course extends Fragment {
    TextView nameText;
    TextView teacherText;
    String id;
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
        nameText = view.findViewById(R.id.name);
        teacherText = view.findViewById(R.id.teacher);
        if(bundle != null) {
            String name = bundle.getString("name");
            String teacher_name = bundle.getString("teacher_name");
            id = bundle.getString("id");
            nameText.setText(name);
            teacherText.setText(teacher_name);
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), seeCourses.class);
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