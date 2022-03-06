package com.nith.hillfair2k22.screens.teams;

import static com.nith.hillfair2k22.apis.MemberVolleyHelper.memberList;
import static com.nith.hillfair2k22.apis.MemberVolleyHelper.teamList;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nith.hillfair2k22.Models.NewMembersList;
import com.nith.hillfair2k22.Models.Teams;
import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.adapters.TeamAdapter;
import com.nith.hillfair2k22.apis.MemberVolleyHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TeamsFragment extends Fragment implements TeamAdapter.OnItemClickListener {
    public static final String EXTRA_TEAM_NAME="Team_Name";
    private final List<Teams> mTeamList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TeamAdapter teamAdapter;
    private static final String TAG="MainActivity";
    public TeamsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.fragment_teams, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        MemberVolleyHelper n2 = new MemberVolleyHelper (getContext());
        n2.getTeamList();
        final androidx.lifecycle.Observer<List<Teams>> observer = new androidx.lifecycle.Observer<List<Teams>>() {
            @Override
            public void onChanged(List<Teams> newMembersList1) {
                Log.e("abcd43",String.valueOf(newMembersList1));
                for(int i=0;i<newMembersList1.size();i++) {
                    Log.e("nnn", newMembersList1.get(i).getClub_name());
                }

                TeamAdapter teamAdapter = new TeamAdapter(newMembersList1,getContext());
                recyclerView.setAdapter(teamAdapter);
                teamAdapter.setItemOnClickListener(TeamsFragment.this);
                StaggeredGridLayoutManager gridLayoutManager =
                        new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(gridLayoutManager);
                for (int i=0; i<newMembersList1.size();i++ ){
                    mTeamList.add(newMembersList1.get(i));
                }

            }
        };

        teamList.observe(getActivity(),observer);
        return view;
    }
    @Override
    public void onItemClick(int position) {
        mTeamList.get(position);
        Intent intent = new Intent(getActivity(), TeamDetailsActivity.class);
        // put team name in the intent as extra
        intent.putExtra(EXTRA_TEAM_NAME, mTeamList.get(position).getClub_name());
        startActivity(intent);
    }

}
