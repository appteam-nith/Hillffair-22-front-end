package com.nith.hillfair2k22.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nith.hillfair2k22.Models.Members_List;
import com.nith.hillfair2k22.Models.NewMembersList;
import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.screens.teams.TeamDetail;

import java.util.List;

public class TeamDetailAdapter extends RecyclerView.Adapter<TeamDetailAdapter.MyViewHolder>{
    private final Context context;
    private final List<NewMembersList> teamDetailList;
    RequestOptions option;

    public TeamDetailAdapter(List<NewMembersList> teamDetailList, Context context) {
        this.context = context;
        this.teamDetailList=teamDetailList;
        option= new RequestOptions().centerCrop().placeholder(R.drawable.loading_image).error(R.drawable.loading_image);
    }

    @NonNull
    @Override
    public TeamDetailAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemDetailView = LayoutInflater.from(context).inflate(R.layout.item_teamdetail, parent, false);
        return new MyViewHolder(itemDetailView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder detailholder, int position) {
        NewMembersList teamDetail = teamDetailList.get(position);
//       detailholder.teamNameTextView.setText(teamDetail.getTeam_name());
        detailholder.teamMemImageView.setImageURI(Uri.parse(teamDetail.getImage()));
        detailholder.teamMemName.setText(teamDetail.getName());
        detailholder.memDesignation.setText(teamDetail.getPosition());
        Glide.with(context).load(teamDetail.getImage().replace("http","https")).apply(option).into(detailholder.teamMemImageView);

    }

     @Override
    public int getItemCount() {
        return teamDetailList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        int id;
        TextView teamNameTextView;
        ImageView teamMemImageView;
        TextView teamMemName;
        TextView memDesignation;


        public MyViewHolder(View detailview) {
            super(detailview);
            id=detailview.getId();
            teamNameTextView = (TextView) detailview.findViewById(R.id.team_name1);
            teamMemImageView = (ImageView) detailview.findViewById(R.id.team_mem_img);
            teamMemName=(TextView) detailview.findViewById(R.id.team_member_name);
            memDesignation=(TextView) detailview.findViewById(R.id.designation);

        }
    }
}
