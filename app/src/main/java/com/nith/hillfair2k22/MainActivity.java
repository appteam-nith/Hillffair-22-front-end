package com.nith.hillfair2k22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.nith.hillfair2k22.adapters.TeamAdapter;
import com.nith.hillfair2k22.adapters.TeamDetailAdapater;
import com.nith.hillfair2k22.screens.teams.Team;
import com.nith.hillfair2k22.screens.teams.TeamDetailsActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity implements TeamAdapter.OnItemClickListener {
    public static final String EXTRA_TEAM_NAME="Team_Name";
   private final List<Team> mTeamList = new ArrayList<>();
   private RecyclerView recyclerView;
   private TeamAdapter teamAdapter;
    private static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_teams);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        addTeamDataFromJSON();
        TeamAdapter teamAdapter = new TeamAdapter(mTeamList, this);
        recyclerView.setAdapter(teamAdapter);
        teamAdapter.setItemOnClickListener(MainActivity.this);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
       recyclerView.setLayoutManager(gridLayoutManager);

       // set on item click listener for a particular team card
       teamAdapter.setItemOnClickListener(new TeamAdapter.OnItemClickListener() {
           @Override
           public void onItemClick(int position) {
               mTeamList.get(position);
               Intent intent = new Intent(getApplicationContext(), TeamDetailsActivity.class);
               // put team name in the intent as extra
               intent.putExtra(EXTRA_TEAM_NAME, mTeamList.get(position).getTeam_Name());
               startActivity(intent);
           }
       });
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
        Intent detailIntent= new Intent(this,TeamDetailsActivity.class);
        Team clickedItem=mTeamList.get(position);
        detailIntent.putExtra(EXTRA_TEAM_NAME,clickedItem.getTeam_Name());
        startActivity(detailIntent);
    }
}