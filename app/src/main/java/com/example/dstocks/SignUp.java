package com.example.dstocks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignUp extends AppCompatActivity {
    private signUpModel signUp=new signUpModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void backToLogin(View view){
        signUp.backToSignUp(this);
        finish();
    }
}
