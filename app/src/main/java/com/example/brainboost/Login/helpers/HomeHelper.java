package com.example.brainboost.Login.helpers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.brainboost.Login.helpers.interfaces.CreatePostBody;
import com.example.brainboost.Login.helpers.interfaces.FetchCallback;
import com.example.brainboost.Login.helpers.interfaces.PostData;
import com.example.brainboost.Login.helpers.requests.HomeRequests;
import com.example.brainboost.Login.views.Home;
import com.example.brainboost.config.Config;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

interface HomeApiService {
	@GET("/api/posts")
	Call<HomeRequests.GetAllPostsResponse> getAllPosts();
    @GET("/api/posts/user/{id}")
	Call<HomeRequests.GetAllPostsResponse> getAllUserPosts(
            @Path("id") String user_id
    );
    @POST("/api/posts")
    Call<HomeRequests.CreatePostResponse> createPost(
            @Body CreatePostBody body
    );

//    @POST("/api/students/{user_id}/course/{course_id}")
//    Call<HomeRequests.SubscribeToCourse> subscribeCourse(
//            @Path("user_id") String user_id,
//            @Path("course_id") String course_id
//    );
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
    public void getAllPosts(Context context, final FetchCallback<List<PostData>> callback){
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        HomeApiService homeApiService = retrofit.create(HomeApiService.class);
        Call<HomeRequests.GetAllPostsResponse> call = homeApiService.getAllPosts();
        call.enqueue(new Callback<HomeRequests.GetAllPostsResponse>() {
            @Override
            public void onResponse(Call<HomeRequests.GetAllPostsResponse> call, Response<HomeRequests.GetAllPostsResponse> response) {
//                Toast.makeText(context, response.body().message, Toast.LENGTH_SHORT).show();
                callback.onSuccess(response.body().data);
            }

            @Override
            public void onFailure(Call<HomeRequests.GetAllPostsResponse> call, Throwable t) {

            }
        });
    }
    public void getAllUserPosts(Context context, final FetchCallback<List<PostData>> callback){
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        HomeApiService homeApiService = retrofit.create(HomeApiService.class);

        Call<HomeRequests.GetAllPostsResponse> call = homeApiService.getAllUserPosts(getUserId(context));
        call.enqueue(new Callback<HomeRequests.GetAllPostsResponse>() {
            @Override
            public void onResponse(Call<HomeRequests.GetAllPostsResponse> call, Response<HomeRequests.GetAllPostsResponse> response) {
//                Toast.makeText(context, response.body().message, Toast.LENGTH_SHORT).show();
                callback.onSuccess(response.body().data);
            }

            @Override
            public void onFailure(Call<HomeRequests.GetAllPostsResponse> call, Throwable t) {

            }
        });
    }
    public void createPost(Context context, String title, String content, String user_id){
                Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        HomeApiService homeApiService = retrofit.create(HomeApiService.class);

        Call<HomeRequests.CreatePostResponse> call = homeApiService.createPost(new CreatePostBody(title, content, user_id));
        call.enqueue(new Callback<HomeRequests.CreatePostResponse>() {
            @Override
            public void onResponse(Call<HomeRequests.CreatePostResponse> call, Response<HomeRequests.CreatePostResponse> response) {
                Toast.makeText(context, response.body().message, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Home.class);
                context.startActivity(intent);

            }

            @Override
            public void onFailure(Call<HomeRequests.CreatePostResponse> call, Throwable t) {
                Toast.makeText(context, "Fail trying to create post", Toast.LENGTH_SHORT).show();
            }
        });
    }
}