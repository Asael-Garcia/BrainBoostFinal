package com.example.brainboost.Login.fragments;

import static androidx.core.content.ContextCompat.getSystemService;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brainboost.Login.views.Home;
import com.example.brainboost.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ImageView user;
    ProgressBar bar;
    ImageView cardgirl;
    ImageView cardboy;
    ImageView carddone;
    TextView time;
    ImageView metup;
    SecondFragment secondFragment= new SecondFragment();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstFragment() {
        // Required empty public constructor
    }

    Button start;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();

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
        View view=inflater.inflate(R.layout.fragment_first, container, false);
        //se toman las imagenes
        user= (ImageView) view.findViewById(R.id.imageUser);
        cardgirl= (ImageView) view.findViewById(R.id.cardgirl);

        cardboy= (ImageView) view.findViewById(R.id.cardboy);
        carddone= (ImageView) view.findViewById(R.id.carddone);

        metup= (ImageView) view.findViewById(R.id.metup);
        bar= (ProgressBar) view.findViewById(R.id.progressBar);

        time= (TextView) view.findViewById(R.id.time);
        start= (Button) view.findViewById(R.id.start);
        //se cargan las imagenes
        user.setImageResource(R.drawable.avatar);
        cardgirl.setImageResource(R.drawable.cardgirl);
        cardboy.setImageResource(R.drawable.cardboy);
        carddone.setImageResource(R.drawable.carddone);
        metup.setImageResource(R.drawable.metup);

        UsageStatsManager usageStatsManager = (UsageStatsManager) requireContext().getSystemService(Context.USAGE_STATS_SERVICE);        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);

        List<UsageStats> usageStatsList = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, cal.getTimeInMillis(), System.currentTimeMillis());

        long totalTimeUsed = 0;
        long minutes=0;

        for (UsageStats usageStats : usageStatsList) {

            if (usageStats.getPackageName().equals("com.example.brainboost")) {
                totalTimeUsed += usageStats.getTotalTimeInForeground();
            }
        }minutes=totalTimeUsed/60000;
        int color = Color.parseColor("#FF5106");
        bar.setProgressTintList(ColorStateList.valueOf(color));
        bar.setMax(60);
        bar.setProgress(Math.toIntExact(minutes));
        time.setText(Math.toIntExact(minutes)+"min");

// totalTimeUsed contiene el tiempo de uso de la aplicación en milisegundos en un día



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener instancia de la actividad
                Home miActividad = (Home) getActivity();
                miActividad.loadFragment(secondFragment);
                BottomNavigationView bottomNavigationView=miActividad.findViewById(R.id.bottom_navigation);
                bottomNavigationView.setSelectedItemId(R.id.secondFragment);

                
            }
        });



        return view;
    }
}