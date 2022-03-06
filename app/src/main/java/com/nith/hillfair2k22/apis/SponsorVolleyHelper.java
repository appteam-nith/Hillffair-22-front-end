package com.nith.hillfair2k22.apis;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.nith.hillfair2k22.Models.NewSponsors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SponsorVolleyHelper {
    Context context;
    RequestQueue requestQueue;
    public SponsorVolleyHelper(Context context){
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);

    }

    // ModelsUsed -> NewSponsors;
    public static MutableLiveData<List<NewSponsors>> sponsorList;
    public void getSponsors(){
        sponsorList = new MutableLiveData<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://anmolcoder.pythonanywhere.com/sponsors/", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<NewSponsors> slist = new ArrayList<>();
                for(int i=0;i<response.length();i++){
                    try {
                        Log.e("sponsor",String.valueOf(response));
                        JSONObject jsonObject = response.getJSONObject(i);
                        int id = jsonObject.getInt("id");
                        String name = jsonObject.getString("name");
                        String link = jsonObject.getString("link");
                        String image = jsonObject.getString("image");
                        String position = jsonObject.getString("position");
                        int priority = jsonObject.getInt("priority");
                        slist.add(new NewSponsors(id,name,link,image,position,priority));


                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("sponserror",e.getMessage());
                    }
                }
                sponsorList.postValue(slist);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorSPons",error.getMessage());
            }
        });
        requestQueue.add(jsonArrayRequest);

    }
    public static MutableLiveData<NewSponsors> sponsorsRead;
    public void readSponsors(int id){
        sponsorsRead = new MutableLiveData<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "http://anmolcoder.pythonanywhere.com/sponsors/"+ id, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.e("Readresponse",String.valueOf(response));
                    int id = response.getInt("id");
                    String name = response.getString("name");
                    String link = response.getString("link");
                    String image = response.getString("image");
                    String position = response.getString("position");
                    int priority = response.getInt("priority");
                    NewSponsors item = new NewSponsors(id,name,link,image,position,priority);
                    sponsorsRead.postValue(item);
                } catch (JSONException e) {
                    Log.e("eRead",e.getMessage());
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorSponsorRead",error.getMessage());

            }
        });
        requestQueue.add(jsonObjectRequest);


    }
}
