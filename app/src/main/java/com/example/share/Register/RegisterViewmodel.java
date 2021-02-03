package com.example.share.Register;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;

public class RegisterViewmodel extends AndroidViewModel {
    private RegisterRepositery registerRepositery;
    private MutableLiveData<FirebaseUser> userlivedata;


    public RegisterViewmodel(@NonNull Application application) {
        super(application);
        registerRepositery=new RegisterRepositery(application);
        userlivedata=registerRepositery.getuserLivedata();
    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    public void Regiter(String email, String password){
        registerRepositery.Register(email,password);
    }

   public MutableLiveData<FirebaseUser> getuserlivedata(){
        return userlivedata;
   }
}
