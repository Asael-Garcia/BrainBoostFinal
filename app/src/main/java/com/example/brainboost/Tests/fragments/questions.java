package com.example.brainboost.Tests.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.brainboost.Courses.views.seeCourses;
import com.example.brainboost.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link questions#newInstance} factory method to
 * create an instance of this fragment.
 */
public class questions extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    score score = new score();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button sendData;
    public questions() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment questions.
     */
    // TODO: Rename and change types and number of parameters
    public static questions newInstance(String param1, String param2) {
        questions fragment = new questions();
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
        View view=inflater.inflate(R.layout.fragment_questions, container, false);
        sendData=view.findViewById(R.id.sendTest);
        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //carga fragmento de las preguntas en fa
                FragmentTransaction transaction= getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container,score);
                transaction.commit();
            }
        });


        return view;
    }
}