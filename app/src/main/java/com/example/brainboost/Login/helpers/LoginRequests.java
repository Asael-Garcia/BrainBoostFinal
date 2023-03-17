package com.example.brainboost.Login.helpers;

class SignupData {
    public String id;
    public String email;
    public String first_name;
    public String last_name;
    public String type;
}


public class LoginRequests {
    public static class SignupResponse {
        public SignupData data;
    }
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
        public LoginBody(String email){
            this.email = email;
            this.password = password;
        }
    }
    public static class LoginResponse {
        public boolean logged;
    }
}
