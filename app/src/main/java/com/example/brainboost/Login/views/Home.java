package com.example.brainboost.Login.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;

import com.example.brainboost.Login.fragments.FirstFragment;
import com.example.brainboost.Login.fragments.FiveFragment;
import com.example.brainboost.Login.fragments.FourFragment;
import com.example.brainboost.Login.fragments.SecondFragment;
import com.example.brainboost.Login.fragments.ThirdFragment;

import com.example.brainboost.Login.helpers.CourseData;
import com.example.brainboost.Login.helpers.FetchCallback;
import com.example.brainboost.Login.helpers.HomeHelper;
import com.example.brainboost.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class Home extends AppCompatActivity {
    FirstFragment firstFragment= new FirstFragment();
    SecondFragment secondFragment= new SecondFragment();
    ThirdFragment thirdFragment= new ThirdFragment();
    FourFragment fourFragment=new FourFragment();
    FiveFragment fiveFragment=new FiveFragment();
    HomeHelper homeHelper = new HomeHelper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnItemSelectedListener(mOnNavigationItemSelectedListener);

        AppOpsManager appOps = (AppOpsManager) getSystemService(Context.APP_OPS_SERVICE);
        int mode = appOps.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS, android.os.Process.myUid(), getPackageName());
        if (mode == AppOpsManager.MODE_ALLOWED) {
            // El permiso está concedido
        } else {
            //para pedir un permiso especial para el timepo de uso
            Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
            startActivity(intent);
        }
        loadFragment(firstFragment);
        homeHelper.getAllCourses(this, new FetchCallback<List<CourseData>>() {
            @Override
            public void onSuccess(List<CourseData> response) {

            }
        });
    }
    private final BottomNavigationView.OnItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.firstFragment:
                    loadFragment(firstFragment);
                    return true;
                case R.id.secondFragment:
                    loadFragment(secondFragment);
                    return true;
                case R.id.thirdFragment:
                    loadFragment(thirdFragment);
                    return true;
                case R.id.fourFragment:
                    loadFragment(fourFragment);
                    return true;
                case R.id.fiveFragment:
                    loadFragment(fiveFragment);
                    return true;
            }
            return false;
        }
    };
    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment);
        transaction.commit();
    }
}