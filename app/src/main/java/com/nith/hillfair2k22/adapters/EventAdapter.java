package com.nith.hillfair2k22.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.nith.hillfair2k22.Models.Events;
import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.screens.eventsAndWorkshops.EventAndWorkshopDetailsFragment;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<Events> eventsModalArrayList;
    private Context context;

    public EventAdapter(List<Events> eventsModalArrayList, Context context) {
        this.eventsModalArrayList = eventsModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_all_events_workshops, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {

        Events events = eventsModalArrayList.get(position);
//        if(events.getType()==1){
            holder.eventTitle.setText(events.getTitle());
            holder.clubName.setText(events.getClubName());
            holder.dateTime.setText(events.getStartTime());
//        }


        holder.item_CV.setOnClickListener(view -> {

            changeFragment(new EventAndWorkshopDetailsFragment(), view, events);


        });
    }

    // Fragment Change
    private void changeFragment(Fragment fragment, View view, Events events) {


        AppCompatActivity activity = (AppCompatActivity) view.getContext();
        //TODO: change replace id to --"fragment_frame_layout"--
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.all_events_workshop_RL, fragment).addToBackStack(null).commit();

        Bundle bundle = new Bundle();
        bundle.putString("Title", events.getTitle());
        bundle.putString("ImageUrl", events.getImage());
        bundle.putString("description", events.getDescription());
        bundle.putString("regUrl", events.getRegUrl());
        fragment.setArguments(bundle);
    }

    @Override
    public int getItemCount() {
        return eventsModalArrayList.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {

        //create variable for views
        private TextView eventTitle, clubName, dateTime;
        private CardView item_CV;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

//             initialize views with ids.
            eventTitle = itemView.findViewById(R.id.Event_name);
            clubName = itemView.findViewById(R.id.Club_name);
            dateTime = itemView.findViewById(R.id.date_time);
            item_CV = itemView.findViewById(R.id.events_RV_item_CV);
        }
    }
}
