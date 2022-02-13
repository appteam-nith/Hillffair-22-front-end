package com.nith.hillfair2k22.screens.eventsAndWorkshops;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class WorkshopsAdapter extends RecyclerView.Adapter<WorkshopsAdapter.WorkShopViewHolder> {

    private ArrayList<WorkshopsModal> workshopsModalArrayList;
    private Context context;

    public WorkshopsAdapter(ArrayList<WorkshopsModal> workshopsModalArrayList, Context context) {
        this.workshopsModalArrayList = workshopsModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public WorkShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkShopViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return workshopsModalArrayList.size();
    }

    public class WorkShopViewHolder extends RecyclerView.ViewHolder{

        public WorkShopViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
