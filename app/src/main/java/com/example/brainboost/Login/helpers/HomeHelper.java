package com.example.brainboost.Login.helpers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface HomeApiService {
	@GET("/api/courses")
	Call<HomeRequests.GetAllCoursesResponse> getAllCourses();
    @GET("/api/courses/{id}")
    Call<HomeRequests.GetCourseByIdResponse> getCouresById(
            @Path("id") String id
    );
}
public class HomeHelper {
    private static HomeApiService API_SERVICE;
    private static final String BASE_URL = "https://51c4-200-63-41-47.ngrok.io";
    public List<CourseData> getAllCourses(Context context, final FetchCallback<List<CourseData>> callback){
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        HomeApiService homeApiService = retrofit.create(HomeApiService.class);
        Call<HomeRequests.GetAllCoursesResponse> call = homeApiService.getAllCourses();
        final List<CourseData> data = new ArrayList<>();
        call.enqueue(new Callback<HomeRequests.GetAllCoursesResponse>() {
            @Override
            public void onResponse(Call<HomeRequests.GetAllCoursesResponse> call, Response<HomeRequests.GetAllCoursesResponse> response) {
                Toast.makeText(context, response.body().msg, Toast.LENGTH_SHORT).show();
                callback.onSuccess(response.body().data);
            }

            @Override
            public void onFailure(Call<HomeRequests.GetAllCoursesResponse> call, Throwable t) {

            }
        });
        return data;
    }
    public List<CourseData> getCourseById(Context context, String id,final FetchCallback<CourseData> callback){
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        HomeApiService homeApiService = retrofit.create(HomeApiService.class);
        Call<HomeRequests.GetCourseByIdResponse> call = homeApiService.getCouresById(id);
        final List<CourseData> data = new ArrayList<>();
        call.enqueue(new Callback<HomeRequests.GetCourseByIdResponse>() {
            @Override
            public void onResponse(Call<HomeRequests.GetCourseByIdResponse> call, Response<HomeRequests.GetCourseByIdResponse> response) {
                Toast.makeText(context, response.body().msg, Toast.LENGTH_SHORT).show();
                callback.onSuccess(response.body().data);
            }
            @Override
            public void onFailure(Call<HomeRequests.GetCourseByIdResponse> call, Throwable t) {

            }
        });
        return data;
    }
}