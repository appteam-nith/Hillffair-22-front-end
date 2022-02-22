package com.nith.hillfair2k22.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.screens.teams.TeamDetail;

import java.util.List;

public class TeamDetailAdapter extends RecyclerView.Adapter<TeamDetailAdapter.MyViewHolder>{
    private final Context context;
    private final List<TeamDetail> teamDetailList;

    public TeamDetailAdapter(List<TeamDetail> teamDetailList, Context context) {
        this.context = context;
        this.teamDetailList=teamDetailList;
    }

    @NonNull
    @Override
    public TeamDetailAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemDetailView = LayoutInflater.from(context).inflate(R.layout.item_teamdetail, parent, false);
        return new MyViewHolder(itemDetailView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder detailholder, int position) {
        TeamDetail teamDetail = teamDetailList.get(position);
        detailholder.teamMemImageView.setImageURI(Uri.parse(teamDetail.getTeam_mem_Img()));
        detailholder.teamMemName.setText(teamDetail.getTeam_Member_Name());
        detailholder.memDesignation.setText(teamDetail.getDesignation());

    }

     @Override
    public int getItemCount() {
        return teamDetailList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView teamNameTextView;
        ImageView teamMemImageView;
        TextView teamMemName;
        TextView memDesignation;


        public MyViewHolder(View detailview) {
            super(detailview);
            teamNameTextView = (TextView) detailview.findViewById(R.id.team_name1);
            teamMemImageView = (ImageView) detailview.findViewById(R.id.team_mem_img);
            teamMemName=(TextView) detailview.findViewById(R.id.team_member_name);
            memDesignation=(TextView) detailview.findViewById(R.id.designation);

        }
    }
}
