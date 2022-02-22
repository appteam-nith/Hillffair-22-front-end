package com.nith.hillfair2k22.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nith.hillfair2k22.Models.Sponsor;
import com.nith.hillfair2k22.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class SponsorsAdapter extends RecyclerView.Adapter<SponsorsAdapter.SponsorsViewHolder> {

    private ArrayList<Sponsor> sponsorsModalArrayList;
    private Context context;

    public SponsorsAdapter(ArrayList<Sponsor> sponsorsModalArrayList, Context context) {
        this.sponsorsModalArrayList = sponsorsModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public SponsorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sponsors, parent, false);
//        return new SponsorsViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SponsorsViewHolder holder, int position) {

        Sponsor sponsor = sponsorsModalArrayList.get(position);
        holder.sponsorDetatils.setText(sponsor.getName());

        Picasso.get().load(sponsor.getImage()).into(holder.sponsorImage);
    }

    @Override
    public int getItemCount() {
        return sponsorsModalArrayList.size();
    }

    public class SponsorsViewHolder extends RecyclerView.ViewHolder{

        private ImageView sponsorImage;
        private TextView sponsorDetatils;
        public SponsorsViewHolder(@NonNull View itemView) {
            super(itemView);

//            sponsorImage =itemView.findViewById(R.id.sponsors_image);
//            sponsorDetatils =itemView.findViewById(R.id.sponsors_detailsTV);
        }
    }
}
