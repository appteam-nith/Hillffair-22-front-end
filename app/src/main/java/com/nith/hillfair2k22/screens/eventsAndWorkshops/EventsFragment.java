package com.nith.hillfair2k22.screens.eventsAndWorkshops;


import static com.nith.hillfair2k22.apis.EventsVolleyHelper.eventList;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nith.hillfair2k22.Models.Events;
import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.adapters.EventAdapter;
import com.nith.hillfair2k22.apis.EventsVolleyHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;


public class EventsFragment extends Fragment {

    private RecyclerView eventsRV;

    private EventAdapter eventsAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events, container, false);

        EventsVolleyHelper eventsVolleyHelper = new EventsVolleyHelper(getContext());
        eventsVolleyHelper.getEvents();
        final androidx.lifecycle.Observer<List<Events>> observer = new androidx.lifecycle.Observer<List<Events>>() {
            @Override
            public void onChanged(List<Events> eventsList) {
                Log.e("abcd43", String.valueOf(eventsList));
                for (int i = 0; i < eventsList.size(); i++) {
                    Log.e("nnn", eventsList.get(i).getClubName());
                }

                List onlyEventList = new ArrayList();

                for (int i = 0; i < eventsList.size(); i++) {
                    if (eventsList.get(i).getType() == 0) {
                        onlyEventList.add(eventsList.get(i));
                    }
                }

                eventsAdapter = new EventAdapter(onlyEventList, getActivity());

                LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                eventsRV.setHasFixedSize(true);

                eventsRV.setLayoutManager(manager);

                // <-----ANIMATIONS---->

                AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(eventsAdapter);
                animationAdapter.setDuration(1000);
                animationAdapter.setInterpolator(new AccelerateDecelerateInterpolator());
                animationAdapter.setFirstOnly(false);
                eventsRV.setAdapter(animationAdapter);
            }
        };
        eventList.observe(getActivity(), observer);


        eventsRV = view.findViewById(R.id.events_RecV);


        return view;
    }


}