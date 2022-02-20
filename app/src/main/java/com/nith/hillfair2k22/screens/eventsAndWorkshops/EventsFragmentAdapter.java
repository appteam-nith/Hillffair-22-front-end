package com.nith.hillfair2k22.screens.eventsAndWorkshops;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class EventsFragmentAdapter  extends FragmentStateAdapter {

    public EventsFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1){
            return new WorkshopFragment();
        }
        return new EventsFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
