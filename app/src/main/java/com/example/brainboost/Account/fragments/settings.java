package com.example.brainboost.Account.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.brainboost.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link settings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class settings extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Switch data;
    Switch ubi;
    Switch noti;
    Switch save;
    Switch play;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public settings() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment settings.
     */
    // TODO: Rename and change types and number of parameters
    public static settings newInstance(String param1, String param2) {
        settings fragment = new settings();
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
        View view= inflater.inflate(R.layout.fragment_settings, container, false);
         data=view.findViewById(R.id.data);
         ubi=view.findViewById(R.id.ubi);
         noti=view.findViewById(R.id.noti);
         save=view.findViewById(R.id.save);
         play=view.findViewById(R.id.play);
        data.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Aquí puedes escribir el código que se ejecutará cuando el estado del Switch Button cambie
                if (isChecked) {
                    Toast.makeText(getContext(), "Se enviaran tus datos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Ya no se enviaran tus datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ubi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Aquí puedes escribir el código que se ejecutará cuando el estado del Switch Button cambie
                if (isChecked) {
                    Toast.makeText(getContext(), "Accesederemos a tu ubicación", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Ya no accesederemos a tu ubicación", Toast.LENGTH_SHORT).show();
                }
            }
        });
        noti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Aquí puedes escribir el código que se ejecutará cuando el estado del Switch Button cambie
                if (isChecked) {
                    Toast.makeText(getContext(), "Se te enviaran notificaciones", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Ya no se te enviaran notificaciones", Toast.LENGTH_SHORT).show();
                }
            }
        });
        save.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Aquí puedes escribir el código que se ejecutará cuando el estado del Switch Button cambie
                if (isChecked) {
                    Toast.makeText(getContext(), "Se podran descargar los videos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Ya no se prodran descargar los videos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        play.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Aquí puedes escribir el código que se ejecutará cuando el estado del Switch Button cambie
                if (isChecked) {
                    Toast.makeText(getContext(), "Se reproduciran videos con datos moviles", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Ya no se reproduciran videos con datos moviles", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}