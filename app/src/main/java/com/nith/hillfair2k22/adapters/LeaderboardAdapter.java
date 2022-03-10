package com.nith.hillfair2k22.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nith.hillfair2k22.Models.Quiz_Leaderboard_Results_Read;
import com.nith.hillfair2k22.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LBViewHolder> {

    private ArrayList<Quiz_Leaderboard_Results_Read> LBArrayList ;
    private Context context;

    public LeaderboardAdapter(ArrayList<Quiz_Leaderboard_Results_Read> LBArrayList, Context context) {
        this.LBArrayList = LBArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public LBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_leader_board, parent, false);
        return new LBViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LBViewHolder holder, int position) {

        Quiz_Leaderboard_Results_Read LB_result_card = LBArrayList.get(position);
        holder.LBname.setText(LB_result_card.getUsername());
        holder.LBscore.setText(String.valueOf(LB_result_card.getScore()));

        Picasso.get().load(LB_result_card.getProfileImage()).into(holder.LBimg);
    }

    @Override
    public int getItemCount() {
        return LBArrayList.size();
    }

    public class LBViewHolder extends RecyclerView.ViewHolder {

        private TextView LBname, LBscore;
        private ImageView LBimg;
        public LBViewHolder(@NonNull View itemView) {
            super(itemView);

            LBname =itemView.findViewById(R.id.LB_username);
            LBscore =itemView.findViewById(R.id.LB_score);
            LBimg = itemView.findViewById(R.id.quiz_profile_IV);
        }
    }
}
