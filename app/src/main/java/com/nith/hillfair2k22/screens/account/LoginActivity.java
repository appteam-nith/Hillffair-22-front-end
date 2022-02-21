package com.nith.hillfair2k22.screens.account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nith.hillfair2k22.MainActivity;
import com.nith.hillfair2k22.R;

public class LoginActivity extends AppCompatActivity {

    private EditText inputEmail,inputPassword;
    private Button btnSignIn;
    private TextView lginAcc,forgotPassword;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail=findViewById(R.id.etEmail);
        inputPassword=findViewById(R.id.etPassword);
        btnSignIn=findViewById(R.id.signin);
        lginAcc=findViewById(R.id.lginAcc);
        forgotPassword=findViewById(R.id.forgotPassword);
        auth=FirebaseAuth.getInstance();

        lginAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email=inputEmail.getText().toString();
                String txt_password=inputPassword.getText().toString();
                loginUser(txt_email,txt_password);

            }
        });
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
    private void loginUser(String email, String password) {

        auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                FirebaseUser user=auth.getCurrentUser();
                if(user.isEmailVerified()){
                    Toast.makeText(LoginActivity.this,"Login Successful" ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }else{
                    inputEmail.setError("Email not Verified");
                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {

                            Toast.makeText(LoginActivity.this,"Email not verified Confirm your email",Toast.LENGTH_LONG).show();
                        }
                    });
                    auth.signOut();
                }
            }
        });

    }
}