package com.nith.hillfair2k22.screens.sponsors;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;

import com.nith.hillfair2k22.Models.Sponsor;
import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.adapters.SponsorsAdapter;
import com.nith.hillfair2k22.screens.eventsAndWorkshops.AllEventsAndWorkshopsFragment;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;


public class SponsorsFragment extends Fragment {

    private RecyclerView sponsorsRV;
    private RelativeLayout sponsorRL;

    private SponsorsAdapter sponsorsAdapter;
    private ArrayList<Sponsor> sponsorsModalArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sponsors, container, false);


        sponsorRL = view.findViewById(R.id.sponsors_RL);

        sponsorsRV = view.findViewById(R.id.sponsors_RecV);
        sponsorsModalArrayList = new ArrayList<>();

        getSponsorsData();

        buildRecyclerView();

        return view;
    }

    private void getSponsorsData() {
        for (int i = 0; i < 19; i++) {
            sponsorsModalArrayList.add(new Sponsor("name","https://media.geeksforgeeks.org/img-practice/banner/dsa-self-paced-thumbnail.png","link","position",1));
        }
    }

    private void buildRecyclerView() {
        sponsorsAdapter = new SponsorsAdapter(sponsorsModalArrayList, getActivity());

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        sponsorsRV.setHasFixedSize(true);

        sponsorsRV.setLayoutManager(manager);

        // <-----ANIMATIONS---->

        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(sponsorsAdapter);
        animationAdapter.setDuration(1000);
        animationAdapter.setInterpolator(new AccelerateDecelerateInterpolator());
        animationAdapter.setFirstOnly(false);
        sponsorsRV.setAdapter(animationAdapter);
    }
}