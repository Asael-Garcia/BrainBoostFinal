package com.example.brainboost.Courses.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.brainboost.Login.helpers.HomeHelper;
import com.example.brainboost.R;

import java.io.IOException;

public class CreateCourse extends AppCompatActivity {


    ImageView imageView;
    EditText titleText;
    EditText contentText;
    Button savePost;
    private static final int REQUEST_CODE = 1;
    HomeHelper homeHelper = new HomeHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_course);
        imageView=findViewById(R.id.imageView);
        titleText = findViewById(R.id.title);
        contentText = findViewById(R.id.content);
        savePost = findViewById(R.id.savePost);

        savePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                post(titleText.getText().toString(), contentText.getText().toString());
            }
        });
    }
    public void postImage(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void post(String title, String content){
        homeHelper.createPost(this, title, content, homeHelper.getUserId(this));
    }

}