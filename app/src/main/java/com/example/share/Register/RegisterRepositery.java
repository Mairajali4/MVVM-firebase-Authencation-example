package com.example.share.Register;

import android.app.Application;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterRepositery {
    private Application application;
    private FirebaseAuth firebaseAuth;
    private MutableLiveData<FirebaseUser> userLivedata;

    public RegisterRepositery(Application application){
        this.application=application;
        this.firebaseAuth=FirebaseAuth.getInstance();
        this.userLivedata=new MutableLiveData<>();
        if(firebaseAuth.getCurrentUser()!=null){
            userLivedata=new MutableLiveData<>();
            userLivedata.postValue(firebaseAuth.getCurrentUser());
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.P)
    public void Register(String email, String password){
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(application.getMainExecutor(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(application.getApplicationContext(),"regidter sucessfully",Toast.LENGTH_SHORT).show();

                    userLivedata.postValue(firebaseAuth.getCurrentUser());
                    
                }else {
                    Toast.makeText(application.getApplicationContext(),"eror:"+task.getException(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public MutableLiveData<FirebaseUser> getuserLivedata() {
        return userLivedata;
    }
}
