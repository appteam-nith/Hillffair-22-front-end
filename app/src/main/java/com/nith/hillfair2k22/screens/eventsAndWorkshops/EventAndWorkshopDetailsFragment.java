package com.nith.hillfair2k22.screens.eventsAndWorkshops;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nith.hillfair2k22.R;
import com.squareup.picasso.Picasso;


public class EventAndWorkshopDetailsFragment extends Fragment {

    private TextView titleTV, descriptionTV;
    private ImageView eventImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_and_workshop_details, container, false);

        titleTV =view.findViewById(R.id.title_TV);
        descriptionTV =view.findViewById(R.id.description_TV);
        eventImage=view.findViewById(R.id.event_image);

        String title = getArguments().getString("Title");
        String imageUrl = getArguments().getString("ImageUrl");
        String description = getArguments().getString("description");

        titleTV.setText(title);
        descriptionTV.setText(description);
        Picasso.get().load(imageUrl).into(eventImage);



        return view;
    }}

