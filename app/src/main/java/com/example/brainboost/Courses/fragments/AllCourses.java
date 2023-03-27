package com.example.brainboost.Courses.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.brainboost.Courses.views.seeCourses;
import com.example.brainboost.Login.helpers.CourseData;
import com.example.brainboost.Login.helpers.FetchCallback;
import com.example.brainboost.Login.helpers.HomeHelper;
import com.example.brainboost.R;

import java.util.List;

public class AllCourses extends Fragment {
    HomeHelper homeHelper = new HomeHelper();
    public AllCourses() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all_courses, container, false);
        homeHelper.getAllCourses(getContext(), new FetchCallback<List<CourseData>>() {
            @Override
            public void onSuccess(List<CourseData> response) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                for(CourseData course: response) {
//                    createLayout(view, course.name, (course.User.first_name + " " + course.User.last_name), course.Lessons.size(), course.id);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", course.name);
                    bundle.putString("teacher_name", (course.User.first_name + " " + course.User.last_name));
                    bundle.putInt("lessons", course.Lessons.size());
                    bundle.putString("id", course.id);
                    fragmentTransaction.add(R.id.contentPanel, Course.class, bundle);
                }
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}