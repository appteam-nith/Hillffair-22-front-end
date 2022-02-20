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
import com.nith.hillfair2k22.screens.teams.Team;
import com.nith.hillfair2k22.screens.teams.TeamsFragment;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewHolder> {
    private OnItemClickListener mListener;
    private final Context context;
    private List<Team> teamList;

    public TeamAdapter(List<Team> teamList, Context context) {
        this.teamList = teamList;
        this.context = context;
    }


    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_team, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Team team = teamList.get(position);

        holder.teamNameTextView.setText(team.getTeam_Name());
        holder.teamImageImageView.setImageURI(Uri.parse(team.getTeamImage()));
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setItemOnClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView teamNameTextView;
        ImageView teamImageImageView;
        public MyViewHolder(View view) {
            super(view);
            teamNameTextView = (TextView) view.findViewById(R.id.team_name);
            teamImageImageView =(ImageView) view.findViewById(R.id.team_img);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
