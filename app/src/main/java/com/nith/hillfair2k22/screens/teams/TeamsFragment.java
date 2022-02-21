package com.nith.hillfair2k22.screens.teams;

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

import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.adapters.TeamAdapter;

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
    private final List<Team> mTeamList = new ArrayList<>();
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
        TeamAdapter teamAdapter = new TeamAdapter(mTeamList,getContext());
        recyclerView.setAdapter(teamAdapter);
        teamAdapter.setItemOnClickListener(TeamsFragment.this);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        addTeamDataFromJSON();
        return view;

    }

    private void addTeamDataFromJSON() {
        try {
            String jsonDataString= readJSONDataFromFile();
            JSONArray jsonArray= new JSONArray(jsonDataString);
            for(int i=0 ; i< jsonArray.length();++i){
                System.out.println(jsonArray.get(i).toString());
                JSONObject itemObj = jsonArray.getJSONObject(i);
                String teamName = itemObj.getString("Team_Name");
                String  teamImgUrl=itemObj.getString("team image");
                Team teamData = new Team(teamName, teamImgUrl);
                mTeamList.add(teamData) ;

            }
        } catch (JSONException | IOException e) {
            Log.d(TAG,"addTeamDataFromJSON:", e);
        }
    }

    // function to read teams' json data from file
    private String readJSONDataFromFile() throws IOException {
        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();
        try {
            String jsonString = null;
            inputStream = getResources().openRawResource(R.raw.teamdata);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            while ((jsonString = bufferedReader.readLine()) != null){
                builder.append(jsonString);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        } return new String(builder);
    }


    @Override
    public void onItemClick(int position) {
        mTeamList.get(position);
        Intent intent = new Intent(getActivity(), TeamDetailsActivity.class);
        // put team name in the intent as extra
        intent.putExtra(EXTRA_TEAM_NAME, mTeamList.get(position).getTeam_Name());
        startActivity(intent);
    }

}
