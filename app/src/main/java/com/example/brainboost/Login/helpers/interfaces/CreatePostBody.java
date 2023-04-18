package com.example.brainboost.Login.helpers.interfaces;

public class CreatePostBody {
        final String title;
        final String content;
        final String user_id;

    public CreatePostBody(String title, String content, String user_id) {
        this.title = title;
        this.content = content;
        this.user_id = user_id;
    }
}
