package com.nith.hillfair2k22.screens.account;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.nith.hillfair2k22.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText inputEmail;
    Button btnNext;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        auth = FirebaseAuth.getInstance();
        inputEmail = findViewById(R.id.etEmail);
        btnNext = findViewById(R.id.next);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = inputEmail.getText().toString().trim();
                if(TextUtils.isEmpty(txt_email)){
                    Toast.makeText(ForgotPasswordActivity.this,"Enter Email",Toast.LENGTH_LONG).show();
                }
                else{
                    auth.sendPasswordResetEmail(txt_email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgotPasswordActivity.this,"Email sent to your email to reset Password",Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(ForgotPasswordActivity.this,"Try Again",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }
}