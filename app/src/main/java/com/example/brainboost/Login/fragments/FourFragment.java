package com.example.brainboost.Login.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.brainboost.Courses.views.seeCourses;
import com.example.brainboost.Messages.fragments.dates;
import com.example.brainboost.Messages.fragments.messages;
import com.example.brainboost.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FourFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FourFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView messages;

    messages FragmenMessages= new messages();
   dates FragmentDates=new dates();
    TextView dates;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FourFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FourFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FourFragment newInstance(String param1, String param2) {
        FourFragment fragment = new FourFragment();
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
        FragmentTransaction transaction= getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content,FragmenMessages);
        transaction.commit();
        View view=inflater.inflate(R.layout.fragment_four, container, false);
        messages=view.findViewById(R.id.messages);
        dates=view.findViewById(R.id.dates);
        String hexColor1 = "#1F1F39"; //
        String hexColor2 = "#858597"; //
        int color1 = Color.parseColor(hexColor1);
        int color2 = Color.parseColor(hexColor2);
        ColorStateList backgrounGray = ColorStateList.valueOf(Color.parseColor("#F4F3FD"));
        ColorStateList backgroundWhite = ColorStateList.valueOf(Color.parseColor("#FFFFFF"));




        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction= getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content,FragmenMessages);
                transaction.commit();
                messages.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
                dates.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);

                messages.setTextColor(getResources().getColor(R.color.anotherBlue));
                dates.setTextColor(getResources().getColor(R.color.gray));

                messages.setBackgroundTintList(backgroundWhite);
                dates.setBackgroundTintList(backgrounGray);

            }
        });
        dates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction= getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content,FragmentDates);
                transaction.commit();

                dates.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
                messages.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);

                dates.setTextColor(getResources().getColor(R.color.anotherBlue));
                messages.setTextColor(getResources().getColor(R.color.gray));

                dates.setBackgroundTintList(backgroundWhite);
                messages.setBackgroundTintList(backgrounGray);
            }
        });
        return view;
    }
}