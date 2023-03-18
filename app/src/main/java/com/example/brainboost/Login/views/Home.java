package com.example.brainboost.Login.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.brainboost.Login.fragments.FirstFragment;
import com.example.brainboost.Login.fragments.FiveFragment;
import com.example.brainboost.Login.fragments.FourFragment;
import com.example.brainboost.Login.fragments.SecondFragment;
import com.example.brainboost.Login.fragments.ThirdFragment;
import com.example.brainboost.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {


    FirstFragment firstFragment= new FirstFragment();
    SecondFragment secondFragment= new SecondFragment();
    ThirdFragment thirdFragment= new ThirdFragment();
    FourFragment fourFragment=new FourFragment();
    FiveFragment fiveFragment=new FiveFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(firstFragment);

    }
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
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