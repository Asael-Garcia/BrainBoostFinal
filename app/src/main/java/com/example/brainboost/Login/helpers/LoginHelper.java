package com.example.brainboost.Login.helpers;

import android.util.Patterns;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.regex.Pattern;

interface LoginApiService{
    @FormUrlEncoded
    @POST("/signup")
    Call <LoginRequests.SignupResponse> signUp(
            @Body LoginRequests.SignupBody body
    );
}

public class LoginHelper {
    private static LoginApiService API_SERVICE;
    private static final String BASE_URL = "http://172.21.249.99:8000";
    public void signUp (android.content.Context context, String email, String password, String first_name, String last_name) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginApiService loginApiService = retrofit.create(LoginApiService.class);
        if (validateAll(context, password, last_name, first_name, email)) {
            Call<LoginRequests.SignupResponse> call = loginApiService.signUp(new LoginRequests.SignupBody(email, password, first_name, last_name));
            call.enqueue(new Callback<LoginRequests.SignupResponse>() {
                @Override
                public void onResponse(Call<LoginRequests.SignupResponse> call, Response<LoginRequests.SignupResponse> response) {

                }
                @Override
                public void onFailure(Call<LoginRequests.SignupResponse> call, Throwable t) {
                    Toast.makeText(context, "Error al loggear", Toast.LENGTH_SHORT).show();
                }
            });
        }
        return ;
    }
    // validación del email
    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
    /*
ASI SE HACE LA LLAMADA EN EL MAIN PARA EL METODO validateName
String username = usernameEditText.getText().toString();
if (validateName(username)) {
    // continuar con el registro del usuario
}
 */
    private boolean validateName(android.content.Context ctx, String first_name) {
        if (first_name.isEmpty()) {
            Toast.makeText(ctx, "Por favor, ingrese un nombre de usuario", Toast.LENGTH_SHORT).show();
            return false;
        } else if (first_name.length() < 4) {
            Toast.makeText(ctx, "El nombre de usuario debe tener al menos 4 caracteres", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validateLastName(android.content.Context ctx, String last_name) {
        if (last_name.isEmpty()) {
            Toast.makeText(ctx, "Por favor, ingrese un apellido para tu usuario", Toast.LENGTH_SHORT).show();
            return false;
        } else if (last_name.length() < 4) {
            Toast.makeText(ctx, "El apellido debe tener al menos 4 caracteres", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validatePassword(android.content.Context ctx, String password) {
        if (password.length() < 8) {
            Toast.makeText(ctx, "La contraseña es demasiado corta", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
            Toast.makeText(ctx, "A la contraseña le falta tener mas punch", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validateAll(android.content.Context ctx, String password, String last_name, String first_name, String email){
        if (!this.validarEmail(email)) return false;
        if (!this.validateName(ctx, first_name)) return false;
        if (!this.validateLastName(ctx, last_name)) return false;
        if (!this.validatePassword(ctx, password)) return false;
        return true;
    }



}
