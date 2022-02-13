package com.nith.hillfair2k22.screens.eventsAndWorkshops;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder> {

    private ArrayList<EventsModal> EventModalArrayList;
    private Context context;

    public EventsAdapter(ArrayList<EventsModal> eventModalArrayList, Context context) {
        EventModalArrayList = eventModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //inflate layout
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return EventModalArrayList.size();
    }





    public class EventViewHolder extends RecyclerView.ViewHolder{

        //create variable for views
        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            // initialize views with ids.
        }
    }
}
