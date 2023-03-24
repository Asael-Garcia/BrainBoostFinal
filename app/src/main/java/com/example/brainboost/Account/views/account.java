package com.example.brainboost.Account.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.brainboost.Account.fragments.editAccount;
import com.example.brainboost.Account.fragments.favorites;
import com.example.brainboost.Account.fragments.help;
import com.example.brainboost.Account.fragments.settings;
import com.example.brainboost.R;

public class account extends AppCompatActivity {
    editAccount FragmentEditAccount= new editAccount();
    favorites FragmentFavorites = new favorites();
    help FragmentHelp= new help();
    settings FragmentSettings= new settings();
    Intent intent;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        value= getIntent().getIntExtra("key",4);
        if(value==0){
            FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container,FragmentFavorites);
            transaction.commit();
        } else if (value==1) {
            FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container,FragmentEditAccount);
            transaction.commit();
        } else if (value==2) {
            FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container,FragmentSettings);
            transaction.commit();
        } else if (value==3) {
            FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container,FragmentHelp);
            transaction.commit();
        }

    }




}