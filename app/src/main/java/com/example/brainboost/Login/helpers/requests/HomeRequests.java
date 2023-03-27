package com.example.brainboost.Login.helpers.requests;

import com.example.brainboost.Courses.fragments.Course;
import com.example.brainboost.Login.helpers.interfaces.CourseData;

import java.util.List;

public class HomeRequests {
    public static class GetAllCoursesResponse{
        public List<CourseData> data;
        public String msg;
    }
    public static class  GetCourseByIdResponse {
        public CourseData data;
        public String msg;
        public boolean isInCourse;
    }
    public static class SubscribeToCourse {
        public String msg;
    }
}
