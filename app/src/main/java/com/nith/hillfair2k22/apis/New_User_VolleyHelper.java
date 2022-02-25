package com.nith.hillfair2k22.apis;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.nith.hillfair2k22.Models.NewUserList;
import com.nith.hillfair2k22.Models.User_List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class New_User_VolleyHelper {
    Context context;
   RequestQueue requestQueue;

    public New_User_VolleyHelper(Context context) {
        this.context = context;
       requestQueue  = Volley.newRequestQueue(context);
    }

    //MODEL Used -> NewUserList;
    // MainActivity code for GetMethod;
    // final androidx.lifecycle.Observer<List<NewUserList>> observer = new androidx.lifecycle.Observer<List<NewUserList>>() {
    //             @Override
    //             public void onChanged(List<NewUserList> newUserLists) {
    //                 Log.e("abcd43",String.valueOf(newUserLists));
    //                 for(int i=0;i<newUserLists.size();i++) {
    //                     Log.e("nnn", newUserLists.get(i).getEmail());
    //                 }
    //            }
    //         };
    //         newUserArrayList.observe(this,observer);

public static MutableLiveData<List<NewUserList>> newUserArrayList;
    public void getUser(){
        newUserArrayList = new MutableLiveData<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://anmolcoder.pythonanywhere.com/user/", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<NewUserList> newlist = new ArrayList<>();
                for(int i=0;i<response.length();i++){
                    try {
                        Log.e("UserGet",String.valueOf(response));
                        JSONObject jsonObject = response.getJSONObject(i);
                        String firebase = jsonObject.getString("firebase");
                        String username = jsonObject.getString("username");
                        String phone = jsonObject.getString("phone");
                        String email = jsonObject.getString("email");
                        int score = jsonObject.getInt("score");
                        String instagramId = jsonObject.getString("instagramId");
                        String profileImage = jsonObject.getString("profileImage");
                        newlist.add(new NewUserList(firebase,username,phone,email,score,instagramId,profileImage));
                    } catch (JSONException e) {
                        Log.e("UserErrorGet",e.getMessage());
                        e.printStackTrace();
                    }

                }
                newUserArrayList.postValue(newlist);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             Log.e("ErrorUserGet",error.getMessage());
            }
        });
        requestQueue.add(jsonArrayRequest);

    }
    public static MutableLiveData<NewUserList> userRead;
    public void readUser(String firebase){
        userRead = new MutableLiveData<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "https://anmolcoder.pythonanywhere.com/user/"+firebase+"/",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.e("UserRead",String.valueOf(response));
                            String firebase = response.getString("firebase");
                            String username = response.getString("username");
                            String phone = response.getString("phone");
                            String email = response.getString("email");
                            int score = response.getInt("score");
                            String instagramId = response.getString("instagramId");
                            String profileImage = response.getString("profileImage");
                            NewUserList item = new NewUserList(firebase,username,phone,email,score,instagramId,profileImage);
                            userRead.postValue(item);
                        } catch (JSONException e) {
                            Log.e("userexception",e.getMessage());
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
    public void checkUser(String email){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://anmolcoder.pythonanywhere.com/user/checkUser/"+email, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
             Log.e("ChekUser",String.valueOf(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    public void postUser(NewUserList alist){
        JSONObject jsonbody  = new JSONObject();
        try {
            jsonbody.put("firebase",alist.getFirebase());
            jsonbody.put("username",alist.getUsername());
            jsonbody.put("phone",alist.getPhone());
            jsonbody.put("email",alist.getEmail());
            jsonbody.put("score",alist.getScore());
            jsonbody.put("instagramId",alist.getInstagramId());
            jsonbody.put("profileImage",alist.getProfileImage());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://anmolcoder.pythonanywhere.com/user/", jsonbody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
               Log.e("PostUser",String.valueOf(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse response = error.networkResponse;
                if (response != null) {
                    if (response.statusCode == 400 || response.statusCode == 404 || response.statusCode == 422 || response.statusCode == 401) {
                        try {
                            JSONObject object = new JSONObject(new String(response.data));
                            if (object.getJSONObject("Errors:").has("username")) {
                                String usernameErr = object.getJSONObject("Errors:").getJSONArray("username").get(0).toString();
                                Log.e("jsonObject", usernameErr);
                                Toast.makeText(context, usernameErr, Toast.LENGTH_SHORT).show();

                            }
                            if (object.getJSONObject("Errors:").has("email")) {
                                String emailErr = object.getJSONObject("Errors:").getJSONArray("email").get(0).toString();
                                Log.e("jsonObject", emailErr);
                                Toast.makeText(context, emailErr, Toast.LENGTH_SHORT).show();

                            } else {
                                String ResultMsg = object.getString("Message");
                                Log.e("jsonObject", ResultMsg);
                                Toast.makeText(context, ResultMsg, Toast.LENGTH_SHORT).show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("jsonerror", e.getMessage());

                        }
                    } else {
                        Log.e("jsonObject", "Error with response code " + response.data);
                        Toast.makeText(context, "Error with response code " + response.statusCode, Toast.LENGTH_SHORT).show();

                    }
                } else {

                    String message = null;
                    if (error instanceof NetworkError) {
                        message = "Cannot connect to Internet...Please check your connection!";
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        Log.e("error", message);
                    } else if (error instanceof ServerError) {
                        message = "The server could not be found. Please try again after some time!!";
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        Log.e("error", message);
                    } else if (error instanceof AuthFailureError) {
                        message = "Cannot connect to Internet...Please check your connection!";
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        Log.e("error", message);
                    } else if (error instanceof ParseError) {
                        message = "Parsing error! Please try again after some time!!";
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        Log.e("error", message);
                    } else if (error instanceof TimeoutError) {
                        message = "Connection TimeOut! Please check your internet connection.";
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        Log.e("error", message);
                    }
                }


            }
        });
        requestQueue.add(jsonObjectRequest);

    }

    public void updateUser (String firebase,NewUserList alist){
        JSONObject jsonbody  = new JSONObject();
        try {
            jsonbody.put("firebase",alist.getFirebase());
            jsonbody.put("username",alist.getUsername());
            jsonbody.put("phone",alist.getPhone());
            jsonbody.put("email",alist.getEmail());
            jsonbody.put("score",alist.getScore());
            jsonbody.put("instagramId",alist.getInstagramId());
            jsonbody.put("profileImage",alist.getProfileImage());
        } catch (JSONException e) {
            Log.e("NewError",e.getMessage());
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, "https://anmolcoder.pythonanywhere.com/user/"+ firebase+"/", jsonbody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("updateUser",String.valueOf(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse response = error.networkResponse;
                if (response != null) {
                    if (response.statusCode == 400 || response.statusCode == 404 || response.statusCode == 422 || response.statusCode == 401) {
                        try {
                            JSONObject object = new JSONObject(new String(response.data));
                            if (object.getJSONObject("Errors:").has("username")) {
                                String usernameErr = object.getJSONObject("Errors:").getJSONArray("username").get(0).toString();
                                Log.e("jsonObject", usernameErr);
                                Toast.makeText(context, usernameErr, Toast.LENGTH_SHORT).show();

                            }
                            if (object.getJSONObject("Errors:").has("email")) {
                                String emailErr = object.getJSONObject("Errors:").getJSONArray("email").get(0).toString();
                                Log.e("jsonObject", emailErr);
                                Toast.makeText(context, emailErr, Toast.LENGTH_SHORT).show();

                            } else {
                                String ResultMsg = object.getString("Message");
                                Log.e("jsonObject", ResultMsg);
                                Toast.makeText(context, ResultMsg, Toast.LENGTH_SHORT).show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("jsonerror", e.getMessage());

                        }
                    } else {
                        Log.e("jsonObject", "Error with response code " + response.data);
                        Toast.makeText(context, "Error with response code " + response.statusCode, Toast.LENGTH_SHORT).show();

                    }
                } else {

                    String message = null;
                    if (error instanceof NetworkError) {
                        message = "Cannot connect to Internet...Please check your connection!";
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        Log.e("error", message);
                    } else if (error instanceof ServerError) {
                        message = "The server could not be found. Please try again after some time!!";
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        Log.e("error", message);
                    } else if (error instanceof AuthFailureError) {
                        message = "Cannot connect to Internet...Please check your connection!";
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        Log.e("error", message);
                    } else if (error instanceof ParseError) {
                        message = "Parsing error! Please try again after some time!!";
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        Log.e("error", message);
                    } else if (error instanceof TimeoutError) {
                        message = "Connection TimeOut! Please check your internet connection.";
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        Log.e("error", message);
                    }
                }

            }
        });
        requestQueue.add(jsonObjectRequest);

    }
    public void partialUserUpdate(String firebase,NewUserList alist){
        JSONObject jsonbody  = new JSONObject();
        try {
            jsonbody.put("firebase",alist.getFirebase());
            jsonbody.put("username",alist.getUsername());
            jsonbody.put("phone",alist.getPhone());
            jsonbody.put("email",alist.getEmail());
            jsonbody.put("score",alist.getScore());
            jsonbody.put("instagramId",alist.getInstagramId());
            jsonbody.put("profileImage",alist.getProfileImage());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PATCH, "https://anmolcoder.pythonanywhere.com/user/"+firebase+"/", jsonbody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("PartialUserUpdate",String.valueOf(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse response = error.networkResponse;
                if (response != null) {
                    if (response.statusCode == 400 || response.statusCode == 404 || response.statusCode == 422 || response.statusCode == 401) {
                        try {
                            JSONObject object = new JSONObject(new String(response.data));
                            if (object.getJSONObject("Errors:").has("username")) {
                                String usernameErr = object.getJSONObject("Errors:").getJSONArray("username").get(0).toString();
                                Log.e("jsonObject", usernameErr);
                                Toast.makeText(context, usernameErr, Toast.LENGTH_SHORT).show();

                            }
                            if (object.getJSONObject("Errors:").has("email")) {
                                String emailErr = object.getJSONObject("Errors:").getJSONArray("email").get(0).toString();
                                Log.e("jsonObject", emailErr);
                                Toast.makeText(context, emailErr, Toast.LENGTH_SHORT).show();

                            } else {
                                String ResultMsg = object.getString("Message");
                                Log.e("jsonObject", ResultMsg);
                                Toast.makeText(context, ResultMsg, Toast.LENGTH_SHORT).show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("jsonerror", e.getMessage());

                        }
                    } else {
                        Log.e("jsonObject", "Error with response code " + response.data);
                        Toast.makeText(context, "Error with response code " + response.statusCode, Toast.LENGTH_SHORT).show();

                    }
                } else {

                    String message = null;
                    if (error instanceof NetworkError) {
                        message = "Cannot connect to Internet...Please check your connection!";
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        Log.e("error", message);
                    } else if (error instanceof ServerError) {
                        message = "The server could not be found. Please try again after some time!!";
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        Log.e("error", message);
                    } else if (error instanceof AuthFailureError) {
                        message = "Cannot connect to Internet...Please check your connection!";
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        Log.e("error", message);
                    } else if (error instanceof ParseError) {
                        message = "Parsing error! Please try again after some time!!";
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        Log.e("error", message);
                    } else if (error instanceof TimeoutError) {
                        message = "Connection TimeOut! Please check your internet connection.";
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        Log.e("error", message);
                    }
                }


            }
        });
        requestQueue.add(jsonObjectRequest);

    }
    public void deleteUser(String firebase) {
//        JSONObject jsonbody = new JSONObject();
//        try {
//            jsonbody.put("firebase",firebase);
//            Log.e("messae","deleted");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, "https://anmolcoder.pythonanywhere.com/user/" + firebase+"/", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
           Log.e("DeleteUser", "Datadeleted");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);

    }

}
