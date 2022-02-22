package com.nith.hillfair2k22.screens.teams;
import static com.nith.hillfair2k22.screens.teams.TeamsFragment.EXTRA_TEAM_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.nith.hillfair2k22.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.nith.hillfair2k22.adapters.TeamDetailAdapter;
import java.util.ArrayList;
import java.util.List;

public class TeamDetailsActivity extends AppCompatActivity {
    private final List<TeamDetail> mTeamDetailList = new ArrayList<>();
    private static final String TAG = "TeamDetailsActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_details);
        RecyclerView recyclerView = findViewById(R.id.teamsDRV);
        Intent intent = getIntent();
        String Team_Name = intent.getStringExtra(EXTRA_TEAM_NAME);
        TextView textViewTeamName = findViewById(R.id.team_name1);
        textViewTeamName.setText(Team_Name);

        TeamDetailAdapter teamDetailAdapter =(TeamDetailAdapter) new TeamDetailAdapter(mTeamDetailList,this);
        recyclerView.setAdapter(teamDetailAdapter);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        addTeamDataFromJSON();
    }
    private void addTeamDataFromJSON() {
        try {
            String jsonDataString= readJSONDataFromFile();
            JSONArray jsonArray= new JSONArray(jsonDataString);
            for(int i=0 ; i< jsonArray.length();++i){
                System.out.println(jsonArray.get(i).toString());
                JSONObject itemObj1 = jsonArray.getJSONObject(i);
                String team_Name = itemObj1.getString("Team_Name");
                String teamMemName = itemObj1.getString("Team_mem_Name");
                String teamMemImgUrl = itemObj1.getString("team member image");
                String designation = itemObj1.getString("designation");
                TeamDetail teamDetailData = new TeamDetail(team_Name, teamMemName, designation, teamMemImgUrl);
                mTeamDetailList.add(teamDetailData) ;

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
}