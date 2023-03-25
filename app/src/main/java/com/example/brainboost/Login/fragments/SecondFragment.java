package com.example.brainboost.Login.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brainboost.Courses.fragments.allCourses;
import com.example.brainboost.Courses.fragments.myCourses;
import com.example.brainboost.Courses.views.seeCourses;
import com.example.brainboost.R;

import org.w3c.dom.Text;

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

    allCourses FragmentAll= new allCourses();
    myCourses FragmentmyCourses = new myCourses();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FrameLayout thing;

    TextView all;
    TextView myCourses;
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
        FragmentTransaction transaction= getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layoutCourses,FragmentAll);
        transaction.commit();
        all= view.findViewById(R.id.all);
        myCourses= view.findViewById(R.id.myCourses);

        //para cambiar lo del fragment de radiogrouo:


        ColorStateList backgrounBlue = ColorStateList.valueOf(Color.parseColor("#3D5CFF"));
        ColorStateList backgroundWhite = ColorStateList.valueOf(Color.parseColor("#FFFFFF"));
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            //
            public void onClick(View v) {

                FragmentTransaction transaction= getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layoutCourses,FragmentAll);
                transaction.commit();
                all.setBackgroundTintList(backgrounBlue);
                myCourses.setBackgroundTintList(backgroundWhite);

                all.setTextColor(getResources().getColor(R.color.white));
                myCourses.setTextColor(getResources().getColor(R.color.gray));
            }
        });
        myCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            //
            public void onClick(View v) {
                FragmentTransaction transaction= getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layoutCourses,FragmentmyCourses);
                transaction.commit();
                myCourses.setBackgroundTintList(backgrounBlue);
                all.setBackgroundTintList(backgroundWhite);

                myCourses.setTextColor(getResources().getColor(R.color.white));
                all.setTextColor(getResources().getColor(R.color.gray));
            }
        });
        return view;
    }
}