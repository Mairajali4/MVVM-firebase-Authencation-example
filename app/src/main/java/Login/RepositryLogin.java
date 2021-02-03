package Login;

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

public class RepositryLogin {
    private Application application;
    private FirebaseAuth firebaseAuth;
    private MutableLiveData<FirebaseUser> userLivedata;

    public RepositryLogin(Application application) {
        this.application=application;
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.userLivedata = new MutableLiveData<>();
        if (firebaseAuth.getCurrentUser() != null) ;
        {
            userLivedata.postValue(firebaseAuth.getCurrentUser());

        }
    }
    @RequiresApi(api = Build.VERSION_CODES.P)
    public  void login(String email,String password){
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(application.getMainExecutor(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    userLivedata.postValue(firebaseAuth.getCurrentUser());
                }else {
                    Toast.makeText(application.getApplicationContext(), "Login Failure: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public MutableLiveData<FirebaseUser> getUserLivedata(){
        return userLivedata;
    }

}