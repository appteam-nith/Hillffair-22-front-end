package com.nith.hillfair2k22.apis;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.nith.hillfair2k22.Models.NewMembersList;
import com.nith.hillfair2k22.Models.NewUserList;
import com.nith.hillfair2k22.Models.Teams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.channels.MulticastChannel;
import java.util.ArrayList;
import java.util.List;

public class MemberVolleyHelper {
    Context context;
    RequestQueue requestQueue;
    public MemberVolleyHelper(Context context){
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);

    }
    // ModelsUsed-> NewMembersList;
    public static MutableLiveData<List<NewMembersList>> memberList;
    public void getMembers(){
        memberList = new MutableLiveData<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://anmolcoder.pythonanywhere.com/members/", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
         List<NewMembersList> Mlist = new ArrayList<>();
          for (int i=0;i<response.length();i++){
              try {
                  Log.e("MemberResponse",String.valueOf(response));
                  JSONObject jsonObject = response.getJSONObject(i);
                  int id = jsonObject.getInt("id");
                  String name = jsonObject.getString("name");
                  String team_name = jsonObject.getString("team_name");
                  String position = jsonObject.getString("position");
                  String image = jsonObject.getString("image");
                  Mlist.add(new NewMembersList(id,name,team_name,position,image));
              } catch (JSONException e) {
                  Log.e("eMember",e.getMessage());
                  e.printStackTrace();
              }
          }
          memberList.postValue(Mlist);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             Log.e("ErrorMember",error.getMessage());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
    public static MutableLiveData<NewMembersList> memberRead;
    public void readMember(int id){
        memberRead = new MutableLiveData<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://anmolcoder.pythonanywhere.com/members/"+id, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.e("ReadMember",String.valueOf(response));
                    int id = response.getInt("id");
                    String name = response.getString("name");
                    String team_name = response.getString("team_name");
                    String position = response.getString("position");
                    String image = response.getString("image");
                    NewMembersList member = new NewMembersList(id,name,team_name,position,image);
                    memberRead.postValue(member);
                } catch (JSONException e) {
                    Log.e("eReadMember",e.getMessage());
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            Log.e("errorReadMember",error.getMessage());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
    public static MutableLiveData<List<Teams>> teamList;
    public void getTeamList(){
        teamList = new MutableLiveData<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://anmolcoder.pythonanywhere.com/members/Team/", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                 List<Teams> Team = new ArrayList<>();
                Log.e("TeamRsp",String.valueOf(response));
                for(int i = 0;i<response.length();i++){
                    try {

                        JSONObject jsonObject = response.getJSONObject(i);
                        String club_name = jsonObject.getString("club_name");
                        Team.add(new Teams(club_name));
                    } catch (JSONException e) {
                        Log.e("ExTeam",String.valueOf(e));
                        e.printStackTrace();
                    }
                }
                teamList.postValue(Team);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               Log.e("ErrorTeam",error.getMessage());
            }
        });
        requestQueue.add(jsonArrayRequest);


    }
    public static MutableLiveData<Teams> teamRead;
    public void getTeamRead(String club_name){
        teamRead = new MutableLiveData<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://anmolcoder.pythonanywhere.com/members/Team/"+club_name, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.e("REadteam",String.valueOf(response));
                    String club_name = response.getString("club_name");
                    Teams T1 = new Teams(club_name);
                    teamRead.postValue(T1);
                } catch (JSONException e) {
                    Log.e("exRead",e.getMessage());
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("errorREadteam",String.valueOf(error));
            }
        });
        requestQueue.add(jsonObjectRequest);
    }


}
