package com.nith.hillfair2k22.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.screens.teams.Team;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewHolder> {
    private onItemClickListener mListener;
    private List<Team> teamList;
    public interface onItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener){
        mListener= (onItemClickListener) listener;
    }
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team,parent,false);
        return new MyViewHolder(itemView);
    }
    public TeamAdapter(List<Team> teamList){
        this.teamList=teamList;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Team team=teamList.get(position);
        holder.Team_Name.setText(team.getTeam_Name());
        holder.Team_Member_Name.setText(team.getTeam_Member_Name());
        holder.Designation.setText(team.getDesignation());


    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView  Team_Name;
        public TextView Team_Member_Name;
        public TextView Designation;
        public ImageView TeamImage;
        public ImageView TeamMemberImage;
        public MyViewHolder(View view){
            super(view);
            Team_Name = (TextView) view.findViewById(R.id.team_name);
            Team_Member_Name = (TextView) view.findViewById(R.id.team_member_name);
            Designation = (TextView) view.findViewById(R.id.designation);
            TeamImage=(ImageView) view.findViewById(R.id.team_img);
            TeamMemberImage=(ImageView) view.findViewById(R.id.team_mem_img);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    if(mListener!= null){
                        int position = getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }

            });

        }
    }

}
