package com.example.brainboost.Login.helpers.requests;

import com.example.brainboost.Courses.fragments.Course;
import com.example.brainboost.Login.helpers.interfaces.PostData;

import java.util.List;

public class HomeRequests {
    public static class GetAllPostsResponse{
        public List<PostData> data;
        public String message;
    }
    public static class SubscribeToCourse {
        public String msg;
    }

    public static class CreatePostResponse {
        public String message;
        public PostData data;
    }
}
