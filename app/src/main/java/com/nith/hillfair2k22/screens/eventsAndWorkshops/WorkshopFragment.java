package com.nith.hillfair2k22.screens.eventsAndWorkshops;


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

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;



public class WorkshopFragment extends Fragment {


    private RecyclerView workshopsRV;

    private EventAdapter workshopsAdapter;
    private ArrayList<Events> workshopsModalArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workshop, container, false);

        workshopsRV = view.findViewById(R.id.workshop_RecV);
        workshopsModalArrayList = new ArrayList<>();

        getWorkshopData();

        buildRecyclerView();

        return view;
    }

    private void getWorkshopData() {
        for (int i=0;i<19; i++){
            workshopsModalArrayList.add(new Events("title","description","starttime","endTime","clubName","platform","img","regUrl",1));

        }
    }

    private void buildRecyclerView() {
        workshopsAdapter = new EventAdapter(workshopsModalArrayList, getActivity());

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        workshopsRV.setHasFixedSize(true);

        workshopsRV.setLayoutManager(manager);


        SlideInBottomAnimationAdapter animationAdapter = new SlideInBottomAnimationAdapter(workshopsAdapter);
        animationAdapter.setDuration(1000);
        animationAdapter.setInterpolator(new AccelerateDecelerateInterpolator());
        animationAdapter.setFirstOnly(false);
        workshopsRV.setAdapter(animationAdapter);



    }
}