package com.nith.hillfair2k22.screens.sponsors;

import static com.nith.hillfair2k22.apis.EventsVolleyHelper.eventList;
import static com.nith.hillfair2k22.apis.SponsorVolleyHelper.sponsorList;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;

import com.nith.hillfair2k22.Models.Events;
import com.nith.hillfair2k22.Models.NewSponsors;
import com.nith.hillfair2k22.Models.Sponsor;
import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.adapters.EventAdapter;
import com.nith.hillfair2k22.adapters.SponsorsAdapter;
import com.nith.hillfair2k22.apis.EventsVolleyHelper;
import com.nith.hillfair2k22.apis.SponsorVolleyHelper;
import com.nith.hillfair2k22.screens.eventsAndWorkshops.AllEventsAndWorkshopsFragment;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;


public class SponsorsFragment extends Fragment {

    private RecyclerView sponsorsRV;
    private RelativeLayout sponsorRL;

    private SponsorsAdapter sponsorsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sponsors, container, false);


        sponsorRL = view.findViewById(R.id.sponsors_RL);

        sponsorsRV = view.findViewById(R.id.sponsors_RecV);

        SponsorVolleyHelper sponsorVolleyHelper = new SponsorVolleyHelper(getContext());
        sponsorVolleyHelper.getSponsors();
        final androidx.lifecycle.Observer<List<NewSponsors>> observer = new androidx.lifecycle.Observer<List<NewSponsors>>() {
            @Override
            public void onChanged(List<NewSponsors> sponsorsList) {
                Log.e("abcd43", String.valueOf(sponsorsList));
                for (int i = 0; i < sponsorsList.size(); i++) {
                    Log.e("nnn", sponsorsList.get(i).getImage());
                }



                sponsorsAdapter = new SponsorsAdapter(sponsorsList, getActivity());

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
        };
        sponsorList.observe(getActivity(), observer);



        return view;
    }


}