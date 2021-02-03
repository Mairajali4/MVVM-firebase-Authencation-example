package Login;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseUser;

public class ViewmodelLogin extends AndroidViewModel {
    private RepositryLogin repositryLogin;
    private MutableLiveData<FirebaseUser> userLivedata;

    public ViewmodelLogin(@NonNull Application application) {
        super(application);
        repositryLogin=new RepositryLogin(application);
        userLivedata=repositryLogin.getUserLivedata();
    }
    @RequiresApi(api = Build.VERSION_CODES.P)
    public  void login(String email, String password){
        repositryLogin.login(email,password);
    }
    public MutableLiveData<FirebaseUser> getUserLivedata(){
        return userLivedata;
    }
}
