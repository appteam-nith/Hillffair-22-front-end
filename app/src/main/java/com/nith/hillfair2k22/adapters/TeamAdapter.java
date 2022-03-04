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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.nith.hillfair2k22.Models.Teams;
import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.screens.teams.Team;
import com.nith.hillfair2k22.screens.teams.TeamsFragment;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewHolder> {
    private OnItemClickListener mListener;
    private final Context context;
    private List<Teams> teamList;
    RequestOptions options;


    public TeamAdapter(List<Teams> teamList, Context context) {
        this.teamList = teamList;
        this.context = context;
        //request option for glide
        options= new RequestOptions().centerCrop().placeholder(R.drawable.loading_image).error(R.drawable.loading_image);
    }



    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_team, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Teams team = teamList.get(position);

        holder.teamNameTextView.setText(team.getClub_name());
        holder.teamImageImageView.setImageURI(Uri.parse(team.getImage()));
        //loading image using glide
        Glide.with(context).load(team.getImage().replace("http","https")).apply(options).into(holder.teamImageImageView);
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
