package com.example.brainboost.Login.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.brainboost.Courses.views.seeCourses;
import com.example.brainboost.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FrameLayout thing;
    RadioGroup radioGroup;
    RadioButton radioButton;
    RadioButton aux;
    Drawable drawable;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        thing= view.findViewById(R.id.nameCourse);
        radioGroup= view.findViewById(R.id.radioCourse);


        //para cambiar de pantalla
        thing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=getContext();
                Intent intento = new Intent(getActivity(), seeCourses.class);
                startActivity(intento);
            }
        });

        //para añadir a favoritos
        thing.setOnLongClickListener(new View.OnLongClickListener() {
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

        //para cambiar lo del fragment de radiogrouo:

        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        int color = Color.parseColor("#3D5CFF");
        int white = Color.parseColor("#FF0000");
        drawable=radioButton.getButtonDrawable();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == -1) {
                    // Ningún RadioButton está seleccionado
                    Toast toast = Toast.makeText(getContext(), "nada esta seleccionado", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                     radioButton = view.findViewById(checkedId);
                    // radioButton es el RadioButton seleccionado
                    if (radioButton.getText()=="Todos"){
                        aux = view.findViewById(R.id.myCourses);
                        aux.setBackgroundColor(white);
                        radioButton.setBackground(drawable);
                        radioButton.setBackgroundColor(color);
                    }else {
                        aux = view.findViewById(R.id.all);
                        aux.setBackgroundColor(white);
                        radioButton.setBackground(drawable);
                        radioButton.setBackgroundColor(color);


                    }
                    Toast toast = Toast.makeText(getContext(), radioButton.getText()+"", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        return view;
    }
}