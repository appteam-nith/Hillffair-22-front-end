package com.nith.hillfair2k22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

import com.cloudinary.android.MediaManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nith.hillfair2k22.screens.account.ViewProfileFragment;
import com.nith.hillfair2k22.screens.blindDate.BlindDateFragment;
import com.nith.hillfair2k22.screens.eventsAndWorkshops.AllEventsAndWorkshopsFragment;
import com.nith.hillfair2k22.screens.home.UserFeedFragment;
import com.nith.hillfair2k22.screens.quiz.AllQuizzesFragment;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        initConfig();
        setContentView(R.layout.activity_main);
        button =(Button) findViewById(R.id.button);

        replaceFragment(new UserFeedFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new UserFeedFragment());
                    break;
                case R.id.quizzes:
                    replaceFragment(new AllQuizzesFragment());
                    break;
                case R.id.events_and_workshops:
                    replaceFragment(new AllEventsAndWorkshopsFragment());
                    break;
                case R.id.blind_date:
                    replaceFragment(new BlindDateFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ViewProfileFragment());
                    break;
            }

            return true;
        });

    }

    public  void initConfig() {
        Map config = new HashMap();
        config.put("cloud_name", "dfinmhios");
        config.put("api_key","981293366339261");
        config.put("api_secret","tknXky4p8K5bRT6Aws_xnAnlAFg");
        //  config.put("secure", true);

        MediaManager.init(MainActivity.this, config);

    }


    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_frame_layout,fragment);
        fragmentTransaction.commit();
    }


}