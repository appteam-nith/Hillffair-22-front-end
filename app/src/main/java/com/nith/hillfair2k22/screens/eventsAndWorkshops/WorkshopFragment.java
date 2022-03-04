package com.nith.hillfair2k22.screens.eventsAndWorkshops;


import static com.nith.hillfair2k22.apis.EventsVolleyHelper.eventList;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

import com.nith.hillfair2k22.Models.Events;
import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.adapters.EventAdapter;
import com.nith.hillfair2k22.apis.EventsVolleyHelper;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;


public class WorkshopFragment extends Fragment {


    private RecyclerView workshopsRV;

    private EventAdapter workshopsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workshop, container, false);

        workshopsRV = view.findViewById(R.id.workshop_RecV);

        EventsVolleyHelper eventsVolleyHelper = new EventsVolleyHelper(getContext());
        eventsVolleyHelper.getEvents();
        final androidx.lifecycle.Observer<List<Events>> observer = new androidx.lifecycle.Observer<List<Events>>() {
            @Override
            public void onChanged(List<Events> eventsList) {
                Log.e("abcd43", String.valueOf(eventsList));
                for (int i = 0; i < eventsList.size(); i++) {
                    Log.e("nnn", eventsList.get(i).getClubName());
                }

                List onlyWorkshopList = new ArrayList();

                for (int i = 0; i < eventsList.size(); i++) {
                    if (eventsList.get(i).getType() == 1) {
                        onlyWorkshopList.add(eventsList.get(i));
                    }
                }

                workshopsAdapter = new EventAdapter(onlyWorkshopList, getActivity());

                LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                workshopsRV.setHasFixedSize(true);

                workshopsRV.setLayoutManager(manager);


                SlideInBottomAnimationAdapter animationAdapter = new SlideInBottomAnimationAdapter(workshopsAdapter);
                animationAdapter.setDuration(1000);
                animationAdapter.setInterpolator(new AccelerateDecelerateInterpolator());
                animationAdapter.setFirstOnly(false);
                workshopsRV.setAdapter(animationAdapter);
            }
        };
        eventList.observe(getActivity(), observer);


        return view;
    }


}