package com.example.brainboost.Courses.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.brainboost.Courses.views.CreateCourse;
import com.example.brainboost.Login.helpers.HomeHelper;
import com.example.brainboost.Login.helpers.interfaces.FetchCallback;
import com.example.brainboost.Login.helpers.interfaces.PostData;
import com.example.brainboost.R;

import java.util.List;

public class myCourses extends Fragment {
    TextView text;  Intent intent;
    Context context;
    HomeHelper homeHelper = new HomeHelper();

    public myCourses() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_courses, container, false);
        text=view.findViewById(R.id.createPost);
        context=getContext();
        getPosts();
        //
        text.setOnClickListener(v -> {
            intent= new Intent(context, CreateCourse.class);
            startActivity(intent);
        });
        return view;
    }
    public void getPosts() {
        homeHelper.getAllUserPosts(getContext(), new FetchCallback<List<PostData>>() {
            @Override
            public void onSuccess(List<PostData> response) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                for (PostData post : response) {
                    Bundle bundle = new Bundle();

                    bundle.putString("title", post.title);
                    bundle.putString("author", (post.User.first_name + " " + post.User.last_name));

                    bundle.putString("id", post.id);
                    bundle.putString("date", post.created_at);
                    fragmentTransaction.add(R.id.contentPanel, Course.class, bundle);
                }
                fragmentTransaction.commit();
            }
        });
    }
}