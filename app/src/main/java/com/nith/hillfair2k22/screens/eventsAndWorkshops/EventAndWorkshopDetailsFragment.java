package com.nith.hillfair2k22.screens.eventsAndWorkshops;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nith.hillfair2k22.R;


public class EventAndWorkshopDetailsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_and_workshop_details, container, false);


        String title = getArguments().getString("Title");
        logd(title);
        String imageUrl = getArguments().getString("ImageUrl");
        logd(imageUrl);

        return view;
    }

    public void logd(String msg){
        Log.d("tag", "logd: "+msg);
    }
}