package com.nith.hillfair2k22.screens.teams;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.nith.hillfair2k22.apis.MemberVolleyHelper.memberList;
import static com.nith.hillfair2k22.screens.teams.TeamsFragment.EXTRA_TEAM_NAME;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.nith.hillfair2k22.Models.Members_List;
import com.nith.hillfair2k22.Models.NewMembersList;
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

import com.nith.hillfair2k22.apis.MemberVolleyHelper;
import com.nith.hillfair2k22.apis.VolleyHelper;
public class TeamDetailsActivity extends AppCompatActivity {
    private final List<NewMembersList> membersLists = new ArrayList<>();
    private static final String TAG = "TeamDetailsActivity";
    TeamDetailAdapter teamDetailAdapter;
    Context context= TeamDetailsActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_details);
        RecyclerView recyclerView = findViewById(R.id.teamsDRV);
        Intent intent = getIntent();
        String Team_Name = intent.getStringExtra(EXTRA_TEAM_NAME);
        TextView textViewTeamName = findViewById(R.id.team_name1);
        textViewTeamName.setText(Team_Name);
        MemberVolleyHelper n1 = new MemberVolleyHelper(TeamDetailsActivity.this);
        n1.getMembers();
         final androidx.lifecycle.Observer<List<NewMembersList>> observer = new androidx.lifecycle.Observer<List<NewMembersList>>() {
                     @Override
                     public void onChanged(List<NewMembersList> newMembersList) {
                         Log.e("abcd43",String.valueOf(newMembersList));
                         for(int i=0;i<newMembersList.size();i++) {
                             Log.e("nnn", newMembersList.get(i).getName());
                         }
                         for (int i=0; i<newMembersList.size();i++ ){
                             membersLists.add(newMembersList.get(i));
                         }
                         Log.e("abcd42",String.valueOf(membersLists.get(0).getName()));
                         teamDetailAdapter =(TeamDetailAdapter) new TeamDetailAdapter(membersLists,getApplicationContext());
                         recyclerView.setAdapter(( teamDetailAdapter));
                         StaggeredGridLayoutManager gridLayoutManager =
                                 new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                         recyclerView.setLayoutManager(gridLayoutManager);
//
                     }
                 };
                 memberList.observe(this,observer);



//         teamDetailAdapter =(TeamDetailAdapter) new TeamDetailAdapter(membersLists,this);
//        recyclerView.setAdapter(( teamDetailAdapter));
//        StaggeredGridLayoutManager gridLayoutManager =
//                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(gridLayoutManager);

    }
}