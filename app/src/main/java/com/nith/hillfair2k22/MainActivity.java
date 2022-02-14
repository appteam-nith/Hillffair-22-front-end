package com.nith.hillfair2k22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nith.hillfair2k22.adapters.TeamAdapter;
import com.nith.hillfair2k22.screens.teams.Team;
import com.nith.hillfair2k22.screens.teams.TeamDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

   private List<Team> teamList = new ArrayList<>();
   private RecyclerView recyclerView;
   private TeamAdapter teamAdapter;
//   private RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareTeamData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        teamAdapter = new TeamAdapter(teamList);
        RecyclerView.LayoutManager tLayoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setAdapter(teamAdapter);
        teamAdapter.setOnItemClickListener(MainActivity.this);
        recyclerView.setLayoutManager(tLayoutManager);
//        mRequestQueue = Volley.newRequestQueue(this);

           }

//    private void parseJSON() {
//        String url="";
//    }

    private  void prepareTeamData(){
               Team team= new Team("App Team" ,"Abc","Executive");
               teamList.add(team);
                team= new Team("Vibhav" ,"ABHI","Executive");
               teamList.add(team);
                team= new Team("PR" ,"xyz","Mentor");
               teamList.add(team);
               team= new Team("PIXO" ,"Abce","Executive");
               teamList.add(team);
                team= new Team("META" ,"Abcj","Volunteer");
               teamList.add(team);
           }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      Intent intent= new Intent(this, TeamDetailsActivity.class);
      Team clickedItem=teamList.get(position);

    }
}