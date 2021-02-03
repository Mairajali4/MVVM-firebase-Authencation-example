package com.example.share.Register;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.share.MainActivity;
import com.example.share.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import Login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText email,password;
    private Button Register;
    private TextView login;
    private RegisterViewmodel registerViewmodel;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerViewmodel= ViewModelProviders.of(this).get(RegisterViewmodel.class);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        Register=findViewById(R.id.register);
        login=findViewById(R.id.login);
        Register.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View v) {
                String Email=email.getText().toString();
                String Pass=password.getText().toString();
                if(Email.length() > 0 && Pass.length()>0){
                    registerViewmodel.Regiter(Email,Pass);

                }

            }
        });

        registerViewmodel.getuserlivedata().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if(firebaseUser !=null){
                    Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}