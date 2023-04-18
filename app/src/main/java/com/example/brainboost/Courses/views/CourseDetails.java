package com.example.brainboost.Courses.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.brainboost.Courses.fragments.Lesson;
import com.example.brainboost.Login.helpers.interfaces.FetchCallback;
import com.example.brainboost.Login.helpers.HomeHelper;
import com.example.brainboost.Login.helpers.interfaces.LessonsData;
import com.example.brainboost.Login.helpers.requests.HomeRequests;
import com.example.brainboost.R;

import java.util.Calendar;

public class CourseDetails extends AppCompatActivity {
    TextView description;
    TextView title;
    TextView course_name2;
    TextView status;
    ImageButton arrow;
    Button button;
    Button register;
    FrameLayout evaluation;
    final int MAX_LINES=3;
    final Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
    }
}