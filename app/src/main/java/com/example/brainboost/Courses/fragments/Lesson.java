package com.example.brainboost.Courses.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.brainboost.Login.helpers.HomeHelper;
import com.example.brainboost.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Lesson#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lesson extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView titleText;
    TextView numberText;
    ImageButton open_video;
    HomeHelper homeHelper = new HomeHelper();

    public Lesson() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Lesson.
     */
    // TODO: Rename and change types and number of parameters
    public static Lesson newInstance(String param1, String param2) {
        Lesson fragment = new Lesson();
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
        View view = inflater.inflate(R.layout.fragment_lesson, container, false);
        Bundle bundle = getArguments();
        if(bundle != null){
            String title = bundle.getString("title");
            int number = bundle.getInt("number");
            String link = bundle.getString("link");
            titleText = view.findViewById(R.id.name);
            numberText = view.findViewById(R.id.number);
            open_video = view.findViewById(R.id.open_video);
            open_video.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url;
                    if(link != null && !link.equals("")) {
                         url = link;
                    }
                    else {
                        url = "https://www.youtube.com/watch?v=YuTuj9YHH_k";
                    }
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
            });
            if(number < 10){
                numberText.setText("0" + number);
            }
            else {
                numberText.setText(number);
            }
            titleText.setText(homeHelper.getSafeString(title));
        }
        return view;
    }
}