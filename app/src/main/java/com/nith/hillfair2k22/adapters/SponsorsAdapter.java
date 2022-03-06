package com.nith.hillfair2k22.adapters;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.nith.hillfair2k22.Models.NewSponsors;
import com.nith.hillfair2k22.Models.Sponsor;
import com.nith.hillfair2k22.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class SponsorsAdapter extends RecyclerView.Adapter<SponsorsAdapter.SponsorsViewHolder> {

    private List<NewSponsors> sponsorsModalArrayList;
    private Context context;

    public SponsorsAdapter(List<NewSponsors> sponsorsModalArrayList, Context context) {
        this.sponsorsModalArrayList = sponsorsModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public SponsorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sponsors, parent, false);
        return new SponsorsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SponsorsViewHolder holder, int position) {

        NewSponsors sponsor = sponsorsModalArrayList.get(position);
        holder.sponsorDetatils.setText(sponsor.getName());
        String imgUrl = sponsor.getImage();

        if (imgUrl.isEmpty()){
//            Picasso.get().load(imgUrl.replace("http", "https")).into(holder.sponsorImage);
        }else {
            Picasso.get().load(imgUrl.replace("http", "https")).into(holder.sponsorImage);
        }

        if(!sponsor.getLink().isEmpty()){
            Uri sponsorsUri = Uri.parse(sponsor.getLink());
            holder.sponsorsCV.setOnClickListener(view -> {
            context. startActivity(new Intent(Intent.ACTION_VIEW, sponsorsUri));
            });
        }


    }

    @Override
    public int getItemCount() {
        return sponsorsModalArrayList.size();
    }

    public class SponsorsViewHolder extends RecyclerView.ViewHolder{

        private ImageView sponsorImage;
        private TextView sponsorDetatils;
        private CardView sponsorsCV;
        public SponsorsViewHolder(@NonNull View itemView) {
            super(itemView);

            sponsorImage =itemView.findViewById(R.id.sponsors_IV);
            sponsorDetatils =itemView.findViewById(R.id.sponsors_detailsTV);
            sponsorsCV=itemView.findViewById(R.id.item_sponsor_card);
        }
    }
}
