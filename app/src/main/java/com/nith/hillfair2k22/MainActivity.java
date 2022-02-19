package com.nith.hillfair2k22;

import static com.nith.hillfair2k22.apis.VolleyHelper.comment_read_details;
import static com.nith.hillfair2k22.apis.VolleyHelper.eventsArrayList;
import static com.nith.hillfair2k22.apis.VolleyHelper.eventsRead_detail;
import static com.nith.hillfair2k22.apis.VolleyHelper.image_feed_detail;
import static com.nith.hillfair2k22.apis.VolleyHelper.like_read_details;
import static com.nith.hillfair2k22.apis.VolleyHelper.member_listArrayList;
import static com.nith.hillfair2k22.apis.VolleyHelper.model_image_feed_listArrayList;
import static com.nith.hillfair2k22.apis.VolleyHelper.quiz_leaderboard_results_listArrayList;
import static com.nith.hillfair2k22.apis.VolleyHelper.quiz_leaderboard_results_readArrayList;
import static com.nith.hillfair2k22.apis.VolleyHelper.quiz_listArrayList;
import static com.nith.hillfair2k22.apis.VolleyHelper.quiz_questions;
import static com.nith.hillfair2k22.apis.VolleyHelper.quiz_readArrayList;
import static com.nith.hillfair2k22.apis.VolleyHelper.sponsorArrayList;
import static com.nith.hillfair2k22.apis.VolleyHelper.user_check_user_read_details;
import static com.nith.hillfair2k22.apis.VolleyHelper.user_listArrayList;
import static com.nith.hillfair2k22.apis.VolleyHelper.user_read_details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.nith.hillfair2k22.Models.Comment_Read;
import com.nith.hillfair2k22.Models.Events;
import com.nith.hillfair2k22.Models.Like_Read;
import com.nith.hillfair2k22.Models.Members_List;
import com.nith.hillfair2k22.Models.Model_Image_Feed_list;
import com.nith.hillfair2k22.Models.Quiz_Leaderboard_Results_List;
import com.nith.hillfair2k22.Models.Quiz_Leaderboard_Results_Read;
import com.nith.hillfair2k22.Models.Quiz_List;
import com.nith.hillfair2k22.Models.Quiz_Questions;
import com.nith.hillfair2k22.Models.Sponsor;
import com.nith.hillfair2k22.Models.User_Check_User_Read;
import com.nith.hillfair2k22.Models.User_List;
import com.nith.hillfair2k22.adapters.TeamAdapter;
import com.nith.hillfair2k22.apis.VolleyHelper;
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


public class MainActivity extends AppCompatActivity {
   private List<Team> mTeamList = new ArrayList<>();
   private RecyclerView recyclerView;
   private TeamAdapter teamAdapter;
   private RecyclerView.LayoutManager layoutManager;
   private static final String TAG="MainActivity";


   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_teams);

        VolleyHelper v1 = new VolleyHelper(MainActivity.this);
        v1.FetchData();
        v1.getImage_Feed_Read("\n" +
                "2c6ddf38-db3b-4640-9c82-ebd752e2efeb");
        v1.getSponsors();
        v1.getEvents();
        v1.getEvents_Read("Rohit");
        v1.getMembers_List();
        v1.getUser_List();
        v1.getQuiz_List();
        v1.getQuiz_Leaderboard_Results_List();
        v1.getQuiz_Leaderboard_Results_Read(1);
        v1.getQuiz_Questions(1);
        v1.getComment_Read(4);
        v1.getQuiz_Read("id");
        v1.getUser_Read("firebase");
        v1.getUser_Check_User_Read("firebase");
        v1.getLike_Read("post_id");
     //  https://www.pexels.com/photo/a-photography-of-a-man-standing-on-a-tree-3680219/
      v1.PostUser("ab1234","Jaipur"
                ,"95935454643","ab@gmail.com","Rohit","yadavrohi23"," https://www.pexels.com/photo/a-photography-of-a-man-standing-on-a-tree-3680219/");
        // v1.imageFeedcreate("https://www.pexels.com/photo/a-photography-of-a-man-standing-on-a-tree-3680219/","Rohit","Jaipur");
       v1.PutUser("ab1234","Rohit Yadav"
               ,"9680382","rohit1411@gmail.com","Rohit  Yadav","yadav11","https://www.pexels.com/photo/a-photography-of-a-man-standing-on-a-tree-3680219/");








        final androidx.lifecycle.Observer<List<Model_Image_Feed_list>> observer = new androidx.lifecycle.Observer<List<Model_Image_Feed_list>>() {
            @Override
            public void onChanged(List<Model_Image_Feed_list> model_image_feed_lists) {
                Log.e("abc", String.valueOf(model_image_feed_lists));
            }

        };
        model_image_feed_listArrayList.observe(this,observer);

        final androidx.lifecycle.Observer<Model_Image_Feed_list> readobserver1 = new androidx.lifecycle.Observer<Model_Image_Feed_list>() {
            @Override
            public void onChanged(Model_Image_Feed_list model_image_feed_list) {
                Log.e("ab1",String.valueOf(model_image_feed_list));
            }




        };
        image_feed_detail.observe(this,readobserver1);





        final androidx.lifecycle.Observer<List<Sponsor>> observer1 = new androidx.lifecycle.Observer<List<Sponsor>>() {
            @Override
            public void onChanged(List<Sponsor> sponsors) {
                Log.e("abc1",String.valueOf(sponsors));
            }
        };
        sponsorArrayList.observe(this,observer1);

        final androidx.lifecycle.Observer<List<Events>> observer2 = new androidx.lifecycle.Observer<List<Events>>() {
            @Override
            public void onChanged(List<Events> events) {
                Log.e("abc2",String.valueOf(events));
            }
        };
        eventsArrayList.observe(this,observer2);
        final androidx.lifecycle.Observer<List<User_List>> observer3 = new androidx.lifecycle.Observer<List<User_List>>() {
            @Override
            public void onChanged(List<User_List> user_lists) {
                Log.e("abc3",String.valueOf(user_lists));
            }
        };
        user_listArrayList.observe(this,observer3);

        final androidx.lifecycle.Observer<Events> readobserver3 = new androidx.lifecycle.Observer<Events>() {
            @Override
            public void onChanged(Events events) {
                Log.e("ab3",String.valueOf(events));
            }
        };
        eventsRead_detail.observe(this,readobserver3);



        final androidx.lifecycle.Observer<List<Members_List>> observer4 = new androidx.lifecycle.Observer<List<Members_List>>() {
            @Override
            public void onChanged(List<Members_List> members_lists) {
                Log.e("abc4",String.valueOf(members_lists));
            }
        };
        member_listArrayList.observe(this,observer4);
        final  androidx.lifecycle.Observer<List<Quiz_List>> observer5 = new androidx.lifecycle.Observer<List<Quiz_List>>() {
            @Override
            public void onChanged(List<Quiz_List> quiz_lists) {
                Log.e("abc5",String.valueOf(quiz_lists));
            }
        };
        quiz_listArrayList.observe(this,observer5);
        final  androidx.lifecycle.Observer<List<Quiz_Leaderboard_Results_List>> observer6 = new androidx.lifecycle.Observer<List<Quiz_Leaderboard_Results_List>>() {
            @Override
            public void onChanged(List<Quiz_Leaderboard_Results_List> quiz_leaderboard_results_lists) {
                Log.e("abc6",String.valueOf(quiz_leaderboard_results_lists));
            }
        };
        quiz_leaderboard_results_listArrayList.observe(this,observer6);

        final androidx.lifecycle.Observer<List<Quiz_Leaderboard_Results_Read>> observer7 = new androidx.lifecycle.Observer<List<Quiz_Leaderboard_Results_Read>>() {
            @Override
            public void onChanged(List<Quiz_Leaderboard_Results_Read> quiz_leaderboard_results_reads) {
                Log.e("abc7",String.valueOf(quiz_leaderboard_results_reads));
            }
        };
        quiz_leaderboard_results_readArrayList.observe(this,observer7);

        final androidx.lifecycle.Observer<Quiz_Questions> observer8 = new androidx.lifecycle.Observer<Quiz_Questions>() {
            @Override
            public void onChanged(Quiz_Questions quiz_questions) {
                Log.e("abc8",String.valueOf(quiz_questions));
            }
        };
        quiz_questions.observe(this,observer8);

        final androidx.lifecycle.Observer<Comment_Read> observer9 = new androidx.lifecycle.Observer<Comment_Read>() {
            @Override
            public void onChanged(Comment_Read comment_reads) {
                Log.e("abc9",String.valueOf(comment_reads));
            }
        };
        comment_read_details.observe(this,observer9);

        final androidx.lifecycle.Observer<List<Quiz_List>> observer10 = new androidx.lifecycle.Observer<List<Quiz_List>>() {
            @Override
            public void onChanged(List<Quiz_List> quiz_lists) {
                Log.e("abc10",String.valueOf(quiz_lists));
            }
        };
        quiz_readArrayList.observe(this,observer10);
        final androidx.lifecycle.Observer<User_List> observer11 = new androidx.lifecycle.Observer<User_List>() {
            @Override
            public void onChanged(User_List user_lists) {
                Log.e("abc11",String.valueOf(user_lists));
            }
        };
        user_read_details.observe(this,observer11);
        final androidx.lifecycle.Observer<Like_Read> observer12 = new androidx.lifecycle.Observer<Like_Read>() {
            @Override
            public void onChanged(Like_Read like_read) {
                Log.e("abc12",String.valueOf(like_read));
            }
        };
        like_read_details.observe(this,observer12);
        final androidx.lifecycle.Observer<User_Check_User_Read> observer13 = new androidx.lifecycle.Observer<User_Check_User_Read>() {
            @Override
            public void onChanged(User_Check_User_Read user_check_user_read) {
                Log.e("abc13",String.valueOf(user_check_user_read));
            }
        };
        user_check_user_read_details.observe(this,observer13);









        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        addTeamDataFromJSON();
        TeamAdapter teamAdapter = new TeamAdapter(mTeamList, this);
        recyclerView.setAdapter(teamAdapter);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
       recyclerView.setLayoutManager(gridLayoutManager);

       // set on item click listener for a particular team card
       teamAdapter.setItemOnClickListener(new TeamAdapter.OnItemClickListener() {
           @Override
           public void onItemClick(int position) {
               mTeamList.get(position);
               Intent intent = new Intent(getApplicationContext(), TeamDetailsActivity.class);
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
               String teamMemName=itemObj.getString("Team_mem_Name");
               String  teamImgUrl=itemObj.getString("team image");
               String teamMemImgUrl=itemObj.getString("team member image");
               String designation=itemObj.getString("designation");
               Team teamData = new Team(teamName, teamMemName, teamImgUrl, teamMemImgUrl, designation);
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
}