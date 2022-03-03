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
import com.nith.hillfair2k22.Models.Events;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EventsVolleyHelper {
    Context context;
    RequestQueue requestQueue;
    public EventsVolleyHelper(Context context){
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
    }

    // ModelsUsed -> Events;

    public static MutableLiveData<List<Events>> eventList;
    public void getEvents() {
        eventList = new MutableLiveData<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://anmolcoder.pythonanywhere.com/events/", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Events> a3 = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        Log.e("EventsR", String.valueOf(response));
                        JSONObject jsonObject = response.getJSONObject(i);
                        a3.add(new Events(jsonObject.getString("title"), jsonObject.getString("description"), jsonObject.getString("startTime"), jsonObject.getString("endTime"), jsonObject.getString("clubName"), jsonObject.getString("platform"), jsonObject.getString("image"), jsonObject.getString("regURL"), jsonObject.getInt("type")));
                    } catch (JSONException e) {
                        Log.e("EventError", String.valueOf(e.getMessage()));
                        e.printStackTrace();
                    }
                }
                eventList.postValue(a3);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }

   public static MutableLiveData<Events> EventRead;
    public void getEvents_Read(String title) {
        EventRead = new MutableLiveData<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "http://anmolcoder.pythonanywhere.com/events/"+title, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.e("EventsRead", String.valueOf(response));
                    Events evdetails = new Events(response.getString("title"), response.getString("description"), response.getString("startTime"), response.getString("endTime"), response.getString("clubName"), response.getString("platform"), response.getString("image"), response.getString("regURL"), response.getInt("type"));
                    EventRead.postValue(evdetails);


                } catch (JSONException e) {
                    Log.e("EventReadError", String.valueOf(e.getMessage()));
                    e.printStackTrace();
                }



            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(jsonObjectRequest);
    }








}
