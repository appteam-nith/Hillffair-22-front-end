package com.nith.hillfair2k22.screens.splashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.nith.hillfair2k22.MainActivity;
import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.screens.account.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                auth = FirebaseAuth.getInstance();
                if (auth.getCurrentUser() == null) {
                    startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                    finish();
                }
                else {
                    Intent i = new Intent(SplashScreenActivity.this,
                            MainActivity.class);
                    //Intent is used to switch from one activity to another.

                    startActivity(i);
                    //invoke the SecondActivity.

                    finish();
                    //the current activity will get finished.
                }
            }
        }, 4000);
    }
}