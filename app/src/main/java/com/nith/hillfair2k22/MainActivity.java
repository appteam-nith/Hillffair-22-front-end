package com.nith.hillfair2k22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

import com.nith.hillfair2k22.screens.eventsAndWorkshops.AllEventsAndWorkshopsFragment;
import com.nith.hillfair2k22.screens.eventsAndWorkshops.EventAndWorkshopDetailsFragment;

public class MainActivity extends AppCompatActivity {

    private Button fragBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragBtn = findViewById(R.id.fragBtn);



        fragBtn.setOnClickListener(view -> {
            fragmentChange(new AllEventsAndWorkshopsFragment());

        });
    }

    private void fragmentChange(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}