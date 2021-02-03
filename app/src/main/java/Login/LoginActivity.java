package Login;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.share.MainActivity;
import com.example.share.R;
import com.example.share.Register.RegisterActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private ViewmodelLogin viewmodelLogin;
    private EditText Email,password;
    private Button buttonlogin;
    private TextView regiter;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        viewmodelLogin=ViewModelProviders.of(this).get(ViewmodelLogin.class);
        Email=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        buttonlogin=findViewById(R.id.login);
        regiter=findViewById(R.id.register);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View v) {
                String email=Email.getText().toString();
                String pass=password.getText().toString();
                if(email.length() > 0 && pass.length() >0){
                    viewmodelLogin.login(email,pass);
                }
            }
        });
        viewmodelLogin.getUserLivedata().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(final FirebaseUser firebaseUser) {
                authStateListener=new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                        if(firebaseUser !=null){
                           Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                           startActivity(intent);
                        }else {
                            Toast.makeText(LoginActivity.this,"logn to continue",Toast.LENGTH_SHORT).show();
                        }
                    }
                };
            }
        });
        regiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    //@Nullable
    //@Override
    //public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        //return super.onCreateView(parent, name, context, attrs);
    //}
}