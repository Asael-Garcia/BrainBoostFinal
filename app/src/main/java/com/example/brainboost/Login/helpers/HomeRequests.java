package com.example.brainboost.Login.helpers;

import java.util.List;

class CourseData{
    public String id;
    public String name;
}

public class HomeRequests {
    public static class GetAllCoursesResponse{
        public List<CourseData> data;
        public String msg;
    }
}
