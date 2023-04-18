package com.example.brainboost.Login.helpers.requests;

public class LoginRequests {
    public static class SignupBody {
        final String email;
        final String password;
        final String first_name;
        final String last_name;
        public SignupBody(String email, String password, String first_name, String last_name){
            this.email = email;
            this.password = password;
            this.first_name = first_name;
            this.last_name = last_name;
        }
    }
    public  static class LoginBody {
        final String email;
        final String password;
        public LoginBody(String email, String password){
            this.email = email;
            this.password = password;
        }
    }
    public static class LoginResponse {
        public String message;
        public AuthResponseData data;
    }
    public static class SignupResponse {
        public AuthResponseData data;
    }
}
