package com.example.dstocks;

import android.content.Context;
import android.content.Intent;

public class loginModel{


    public String loginStart(String email, String password){
        String response="SUCCESSFULL";

        return response;
    }
    public void registerNew(Context context){
        Intent register=new Intent(context,SignUp.class);
        context.startActivity(register);
    }

    public String guestProcess(){
        String response="SUCCESSFULL";
        return response;
    }

    public void proceedToHomePage(Context context){

        Intent register=new Intent(context,HomePage.class);
        context.startActivity(register);
    }

    private void connectToServer(){

    }
}
