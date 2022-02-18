package com.nith.hillfair2k22.screens.eventsAndWorkshops;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nith.hillfair2k22.R;

import java.util.ArrayList;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder> {

    private ArrayList<EventsModal> eventsModalArrayList;
    private Context context;

    public EventsAdapter(ArrayList<EventsModal> eventsModalArrayList, Context context) {
        this.eventsModalArrayList = eventsModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //inflate layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_all_event_workshops, parent, false);
        return new EventViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {

        EventsModal eventsModal = eventsModalArrayList.get(position);
        holder.eventTitle.setText(eventsModal.getEventTitle());
        holder.clubName.setText(eventsModal.getEventTitle());
        holder.dateTime.setText(eventsModal.getEventStartDate());






        holder.item_CV.setOnClickListener(view -> {

            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            Fragment eventAndWorkshopDetailsFragment = new EventAndWorkshopDetailsFragment();
            //TODO: replace id
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, eventAndWorkshopDetailsFragment).addToBackStack("tag").commit();

            Bundle bundle = new Bundle();
            bundle.putString("Title",eventsModal.getEventTitle());
            bundle.putString("ImageUrl",eventsModal.getImageUrl());
            bundle.putString("description",eventsModal.getEventDescription());
            bundle.putString("regUrl",eventsModal.getEventRegUrl());
            eventAndWorkshopDetailsFragment.setArguments(bundle);

        });







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

            // initialize views with ids.
            eventTitle = itemView.findViewById(R.id.Event_name);
            clubName = itemView.findViewById(R.id.Club_name);
            dateTime = itemView.findViewById(R.id.date_time);
            item_CV = itemView.findViewById(R.id.events_RV_item_CV);
        }
    }
}
