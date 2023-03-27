package com.example.brainboost.Login.helpers;

import java.util.List;

public class HomeRequests {
    public static class GetAllCoursesResponse{
        public List<CourseData> data;
        public String msg;
    }
    public static class  GetCourseByIdResponse {
        public CourseData data;
        public String msg;
    }
}
