package com.example.brainboost.Login.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.brainboost.Account.views.account;
import com.example.brainboost.Courses.views.seeCourses;
import com.example.brainboost.Login.views.Home;
import com.example.brainboost.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FiveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FiveFragment extends Fragment {
    Intent intento;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList <LinearLayout> things= new ArrayList<>();

    public FiveFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FiveFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FiveFragment newInstance(String param1, String param2) {
        FiveFragment fragment = new FiveFragment();
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
        View view = inflater.inflate(R.layout.fragment_five, container, false);
        LinearLayout favorites = view.findViewById(R.id.favorites);
        LinearLayout editAccount = view.findViewById(R.id.editAccount);
        LinearLayout settings = view.findViewById(R.id.settings);
        LinearLayout close=view.findViewById(R.id.close);

        intento = new Intent(getActivity(), account.class);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //eliminar preferencia
                // Obtener una instancia de SharedPreferences
                SharedPreferences prefs = getContext().getSharedPreferences("myPrefs", MODE_PRIVATE);

// Obtener un editor de SharedPreferences
                SharedPreferences.Editor editor = prefs.edit();
                Toast toast = Toast.makeText(getContext(), "Cambiado aaaaaa"+prefs.getBoolean("loggedIn",false), Toast.LENGTH_LONG);
                toast.show();


// Eliminar la preferencia con el nombre "my_preference"
                editor.putBoolean("loggedIn",false);
                toast = Toast.makeText(getContext(), "Cambiado"+prefs.getBoolean("loggedIn",false), Toast.LENGTH_LONG);
                toast.show();

// Guardar los cambios
                editor.apply();

            }
        });
        favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intento.putExtra("key",0);
                startActivity(intento);
            }
        });
        editAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intento.putExtra("key",1);
                startActivity(intento);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intento.putExtra("key",2);
                startActivity(intento);
            }
        });
        return view;
    }

}