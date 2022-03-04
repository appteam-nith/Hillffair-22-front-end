package com.nith.hillfair2k22.screens.eventsAndWorkshops;

import android.content.Intent;
import android.net.Uri;
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

    private TextView titleTV, descriptionTV, regBtn;
    private ImageView eventImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_and_workshop_details, container, false);

        titleTV =view.findViewById(R.id.title_event_details_TV);
        descriptionTV =view.findViewById(R.id.description_TV);
        eventImage=view.findViewById(R.id.event_image);
        regBtn=view.findViewById(R.id.reg_btn);

        String title = getArguments().getString("Title");
        String imageUrl = getArguments().getString("ImageUrl");
        String description = getArguments().getString("description");
        String regUrl = getArguments().getString("regUrl");

        titleTV.setText(title);
        descriptionTV.setText(description);
        if (imageUrl.isEmpty()){
//            Picasso.get().load(imgUrl.replace("http", "https")).into(holder.sponsorImage);
        }else {
            Picasso.get().load(imageUrl).into(eventImage);
        }
        regBtn.setOnClickListener(view1 -> {
            Uri uri = Uri.parse(regUrl);
            startActivity(new Intent(Intent.ACTION_VIEW,uri));
        });



        return view;
    }}
