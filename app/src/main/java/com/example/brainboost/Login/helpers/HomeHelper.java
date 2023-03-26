package com.example.brainboost.Login.helpers;

import android.content.Context;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

interface HomeApiService {
	@GET("/api/courses")
	Call<HomeRequests.GetAllCoursesResponse> getAllCourses();

}
public class HomeHelper {
    private static HomeApiService API_SERVICE;
    private static final String BASE_URL = "https://brain-boost.fly.dev/";
    public void getAllCourses(Context context){
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        HomeApiService homeApiService = retrofit.create(HomeApiService.class);
        Call<HomeRequests.GetAllCoursesResponse> call = homeApiService.getAllCourses();
        final HomeRequests.GetAllCoursesResponse data = new HomeRequests.GetAllCoursesResponse();
        call.enqueue(new Callback<HomeRequests.GetAllCoursesResponse>() {
            @Override
            public void onResponse(Call<HomeRequests.GetAllCoursesResponse> call, Response<HomeRequests.GetAllCoursesResponse> response) {
                Toast.makeText(context, response.body().msg, Toast.LENGTH_SHORT).show();
                data.data = response.body().data;
            }

            @Override
            public void onFailure(Call<HomeRequests.GetAllCoursesResponse> call, Throwable t) {

            }
        });
    }
}