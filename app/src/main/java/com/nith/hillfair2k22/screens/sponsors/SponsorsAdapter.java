package com.nith.hillfair2k22.screens.sponsors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SponsorsAdapter extends RecyclerView.Adapter<SponsorsAdapter.SponsorsViewHolder> {

    private ArrayList<SponsorsModal> sponsorsModalArrayList;
    private Context context;

    public SponsorsAdapter(ArrayList<SponsorsModal> sponsorsModalArrayList, Context context) {
        this.sponsorsModalArrayList = sponsorsModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public SponsorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SponsorsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return sponsorsModalArrayList.size();
    }

    public class SponsorsViewHolder extends RecyclerView.ViewHolder{
        public SponsorsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
