package com.nith.hillfair2k22.screens.eventsAndWorkshops;

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
import com.nith.hillfair2k22.R;

import java.util.ArrayList;
import java.util.Objects;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

public class EventsFragment extends Fragment {

    private RecyclerView eventsRV;
    private FloatingActionButton eventFab,teamsFab,sponsorsFab;

    private EventsAdapter eventsAdapter;
    private ArrayList<EventsModal> eventsModalArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events, container, false);



        eventsRV = view.findViewById(R.id.events_RecV);

        eventFab = view.findViewById(R.id.btn_team_sponsor);
        teamsFab = view.findViewById(R.id.btn_teams);
        sponsorsFab = view.findViewById(R.id.btn_sponsors);

        eventsModalArrayList = new ArrayList<>();


        getEventData();

        buildRecyclerView();

        //<---Fab--->
        
        if (eventFab==null){
            Toast.makeText(getActivity(), "NULL", Toast.LENGTH_SHORT).show();
        }

//        eventFab.setOnClickListener(view1 -> {
//
//            teamsFab.setVisibility(View.VISIBLE);
//            sponsorsFab.setVisibility(View.VISIBLE);
//
//        });




        return view;
    }

    


    private void buildRecyclerView() {

        eventsAdapter = new EventsAdapter(eventsModalArrayList, getActivity());

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        eventsRV.setHasFixedSize(true);

        eventsRV.setLayoutManager(manager);

//        eventsRV.setAdapter(eventsAdapter);

        // <-----ANIMATIONS---->

        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(eventsAdapter);
        animationAdapter.setDuration(1000);
        animationAdapter.setInterpolator(new AccelerateDecelerateInterpolator());
        animationAdapter.setFirstOnly(false);
        eventsRV.setAdapter(animationAdapter);



    }

    private void getEventData() {
        for (int i = 0; i < 19; i++) {
            eventsModalArrayList.add(new EventsModal("Treasure Hunt Event", "English Club", "04 April 2022", false));
        }
    }
}