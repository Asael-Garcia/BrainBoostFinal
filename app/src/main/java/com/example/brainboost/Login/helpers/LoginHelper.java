package com.example.brainboost.Login.helpers;

import android.util.Patterns;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import okhttp3.*;

import java.util.regex.Pattern;

public interface LoginApiService{
    @FormUrlEncoded
    @POST("signup")
    Call<SimpleResponse> signUp(
            @Field("email") String email,
            @Field("first_name") String first_name,
            @Field("last_name") String last_name,
            @Field("password") String password
    );
}

public class LoginHelper {
    private static LoginApiService API_SERVICE;
    private static final String BASE_URL = "ruta";

    public static LoginApiService getApiService(){
        // Creamos un interceptor y le indicamos el log level a usar
        final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Asociamos el interceptor a las peticiones
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()) // <-- set log level
                    .build();

            API_SERVICE = retrofit.create(LoginApiService.class);
        }

        return API_SERVICE;
    }
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
    public boolean validateName(android.content.Context ctx, String first_name) {
        if (first_name.isEmpty()) {
            Toast.makeText(ctx, "Por favor, ingrese un nombre de usuario", Toast.LENGTH_SHORT).show();
            return false;
        } else if (first_name.length() < 4) {
            Toast.makeText(ctx, "El nombre de usuario debe tener al menos 4 caracteres", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean validateLastName(android.content.Context ctx, String last_name) {
        if (last_name.isEmpty()) {
            Toast.makeText(ctx, "Por favor, ingrese un apellido para tu usuario", Toast.LENGTH_SHORT).show();
            return false;
        } else if (last_name.length() < 4) {
            Toast.makeText(ctx, "El apellido debe tener al menos 4 caracteres", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean validatePassword(android.content.Context ctx, String password) {
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

    public boolean llamarTodo(android.content.Context ctx, String password, String last_name, String first_name, String email){
        if (!this.validarEmail(email)) return false;
        if (!this.validateName(ctx, first_name)) return false;
        if (!this.validateLastName(ctx, last_name)) return false;
        if (!this.validatePassword(ctx, password)) return false;
        return true;
    }



}
