package com.nith.hillfair2k22.screens.eventsAndWorkshops;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.screens.sponsors.SponsorsFragment;
import com.nith.hillfair2k22.screens.teams.TeamsFragment;

import java.util.concurrent.atomic.AtomicBoolean;


public class AllEventsAndWorkshopsFragment extends Fragment {

    private TabLayout eventTabLayout;
    private ViewPager2 eventViewPager2;
    private EventsFragmentAdapter adapter;

    private FloatingActionButton eventFab, teamsFab, sponsorsFab;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_all_events_and_workshops, container, false);

        eventFab = view.findViewById(R.id.btn_team_sponsor);
        teamsFab = view.findViewById(R.id.btn_teams);
        sponsorsFab = view.findViewById(R.id.btn_sponsors);

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();


        eventTabLayout = view.findViewById(R.id.events_tab_layout);
        eventViewPager2 = view.findViewById(R.id.events_TL_viewP2);

        eventTabLayout.addTab(eventTabLayout.newTab().setText("Events"));
        eventTabLayout.addTab(eventTabLayout.newTab().setText("Workshops"));

        FragmentManager fragmentManager = getParentFragmentManager();
        adapter = new EventsFragmentAdapter(fragmentManager, getLifecycle());
        eventViewPager2.setAdapter(adapter);

        eventTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                eventViewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        eventViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                eventTabLayout.selectTab(eventTabLayout.getTabAt(position));
            }
        });

        //<--FAB--->

        AtomicBoolean fabExpanded = new AtomicBoolean(false);
        eventFab.setOnClickListener(view1 -> {

            if (fabExpanded.get() == false) {
                teamsFab.setVisibility(View.VISIBLE);
                sponsorsFab.setVisibility(View.VISIBLE);
                eventFab.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_cancel));
                fabExpanded.set(true);
            } else {
                teamsFab.setVisibility(View.GONE);
                sponsorsFab.setVisibility(View.GONE);
                eventFab.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_three_dots));
                fabExpanded.set(false);
            }


        });

        teamsFab.setOnClickListener(view1 -> {
            changeFragment(new TeamsFragment());

        });

        sponsorsFab.setOnClickListener(view1 -> {
            changeFragment(new SponsorsFragment());

        });

        return view;
    }


    private void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //TODO : replace id
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


}