package com.example.dstocks;

import android.content.Context;
import android.content.Intent;

public class signUpModel {
    public void backToSignUp(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);

    }
}
