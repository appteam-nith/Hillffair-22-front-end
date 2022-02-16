package com.nith.hillfair2k22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nith.hillfair2k22.adapters.TeamAdapter;
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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

   private List<Team> mteamList = new ArrayList<>();
   private RecyclerView recyclerView;
   private TeamAdapter teamAdapter;
   private RecyclerView.LayoutManager layoutManager;
   private static final String TAG="MainActivity";
//   private RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_teams);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        TeamAdapter teamAdapter=new TeamAdapter(mteamList);
        recyclerView.setAdapter(teamAdapter);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
       recyclerView.setLayoutManager(gridLayoutManager);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
// Attach the layout manager to the recycler view


        addTeamDataFromJSON();
//        mRequestQueue= Volley.newRequestQueue(this);
           }

    private void addTeamDataFromJSON() {
           try {
               String jsonDataString= readJSONDataFromFile();
               JSONArray jsonArray= new JSONArray(jsonDataString);
               for(int i=0 ; i< jsonArray.length();++i){
                   JSONObject itemObj = jsonArray.getJSONObject(i);
                   String teamName = itemObj.getString("Team_Name");
                   String teamMemName=itemObj.getString("Team_mem_Name");
                   String  teamImgUrl=itemObj.getString("team image");
                   String teamMemImgUrl=itemObj.getString("team member image");
                   String designation=itemObj.getString("designation");
                   Team teamData = new Team(teamName,teamMemName,teamImgUrl,teamMemImgUrl,designation);
                  mteamList.add(teamData) ;

               }
           } catch (JSONException | IOException e) {
               Log.d(TAG,"addTeamDataFromJSON:",e);
           }

    }

    private String readJSONDataFromFile() throws IOException {
        InputStream inputStream=null;
        StringBuilder builder=new StringBuilder();
        try {
            String jsonString=null;
            inputStream= getResources().openRawResource(R.raw.teamdata);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            while ((jsonString=bufferedReader.readLine())!=null){
                builder.append(jsonString);
            }
        }finally {
            if(inputStream!= null){
                inputStream.close();
            }
        } return new String(builder);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      Intent intent= new Intent(this, TeamDetailsActivity.class);
      Team clickedItem=mteamList.get(position);

    }
}