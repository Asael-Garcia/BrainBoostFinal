package com.example.brainboost.Login.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.brainboost.Login.helpers.interfaces.CourseData;
import com.example.brainboost.Login.helpers.interfaces.FetchCallback;
import com.example.brainboost.Login.helpers.requests.HomeRequests;
import com.example.brainboost.config.Config;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

interface HomeApiService {
	@GET("/api/courses")
	Call<HomeRequests.GetAllCoursesResponse> getAllCourses();
    @GET("/api/courses/{id}/{user_id}")
    Call<HomeRequests.GetCourseByIdResponse> getCourseById(
            @Path("id") String id,
            @Path("user_id") String user_id
    );
    @POST("/api/students/{user_id}/course/{course_id}")
    Call<HomeRequests.SubscribeToCourse> subscribeCourse(
            @Path("user_id") String user_id,
            @Path("course_id") String course_id
    );
}
public class HomeHelper {
    private static HomeApiService API_SERVICE;
    private static final String BASE_URL = Config.API_URL;
    public String getSafeString(String base){
        String res = base.substring(0, 17);
        res += "...";
        return res;
    }
    public String getUserId (Context ctx) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        return sharedPreferences.getString("userID", "");
    }
    public void getMyCourses(Context context, final FetchCallback<List<CourseData>> callback){

    }
    public void subscribe (String course_id, String user_id, final FetchCallback<String> callback){
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        HomeApiService homeApiService = retrofit.create(HomeApiService.class);
        Call<HomeRequests.SubscribeToCourse> call = homeApiService.subscribeCourse(user_id, course_id);
//        call.enqueue(new Callback<HomeRequests.SubscribeToCourse>() {
//            @Override
//            public void onResponse(Call<HomeRequests.SubscribeToCourse> call, Response<HomeRequests.SubscribeToCourse> response) {
//                assert response.body() != null;
//                callback.onSuccess(response.body().msg);
//            }
//            @Override
//            public void onFailure(Call<HomeRequests.SubscribeToCourse> call, Throwable t) {
//
//            }
//        });
    }
    public void getAllCourses(Context context, final FetchCallback<List<CourseData>> callback){
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        HomeApiService homeApiService = retrofit.create(HomeApiService.class);
        Call<HomeRequests.GetAllCoursesResponse> call = homeApiService.getAllCourses();
//        call.enqueue(new Callback<HomeRequests.GetAllCoursesResponse>() {
//            @Override
//            public void onResponse(Call<HomeRequests.GetAllCoursesResponse> call, Response<HomeRequests.GetAllCoursesResponse> response) {
//                Toast.makeText(context, response.body().msg, Toast.LENGTH_SHORT).show();
//                callback.onSuccess(response.body().data);
//            }
//
//            @Override
//            public void onFailure(Call<HomeRequests.GetAllCoursesResponse> call, Throwable t) {
//
//            }
//        });
    }
    public void getCourseById(Context context, String id, final FetchCallback<HomeRequests.GetCourseByIdResponse> callback){
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        HomeApiService homeApiService = retrofit.create(HomeApiService.class);
        Call<HomeRequests.GetCourseByIdResponse> call = homeApiService.getCourseById(id, getUserId(context));
        final List<CourseData> data = new ArrayList<>();
//        call.enqueue(new Callback<HomeRequests.GetCourseByIdResponse>() {
//            @Override
//            public void onResponse(Call<HomeRequests.GetCourseByIdResponse> call, Response<HomeRequests.GetCourseByIdResponse> response) {
//                callback.onSuccess(response.body());
//            }
//            @Override
//            public void onFailure(Call<HomeRequests.GetCourseByIdResponse> call, Throwable t) {
//
//            }
//        });
    }
}