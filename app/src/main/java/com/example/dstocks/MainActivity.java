package com.example.dstocks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    loginModel login=new loginModel();
    public static ArrayList<String> userFavs;
    public static void setFavs(ArrayList<String> a){
        userFavs=a;
    }
    private EditText email;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.input_email);
        password=findViewById(R.id.input_password);
    }
    public void guestProcess(View view){
        login.guestProcess();
    }
    public void signUp(View view){
        login.registerNew(this);
    }
    public void login(View view){
        String response=login.loginStart(email.getText().toString(),password.getText().toString());
        if(response=="SUCCESSFULL"){
            login.proceedToHomePage(this);
        }
    }
}
