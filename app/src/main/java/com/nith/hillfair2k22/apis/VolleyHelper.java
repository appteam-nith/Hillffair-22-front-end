package com.nith.hillfair2k22.apis;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;

public class VolleyHelper {
    public VolleyHelper(Context context) {
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
    }
//feedcomments;
    //Event-details;

    //Team-list;
    //Quizquestions;
    Context context;
    RequestQueue requestQueue;
    String Server_Url_Image_Feed_list = "https://anmolcoder.pythonanywhere.com/imagefeed/";
    String Server_Url_Image_Feed_Read = "https://anmolcoder.pythonanywhere.com/imagefeed/";
    String Server_Url_Sponsors = "https://anmolcoder.pythonanywhere.com/sponsors/";
    String Server_Url_Events = "https://anmolcoder.pythonanywhere.com/events/";
    String Server_Url_EventsRead = "https://anmolcoder.pythonanywhere.com/events/";
    String Server_Url_Member_List = "https://anmolcoder.pythonanywhere.com/members/";
    String Server_Url_User_List = "https://anmolcoder.pythonanywhere.com/user/";
    String Server_Url_Quiz_List = "https://anmolcoder.pythonanywhere.com/quiz/";
    String Server_Url_Quiz_Leaderboard_Results_List = "https://anmolcoder.pythonanywhere.com/quiz/leaderboard/results/";
    String Server_Url_Quiz_Leaderboard_Results_Read = "https://anmolcoder.pythonanywhere.com/quiz/leaderboard/results/";
    String Server_Url_Quiz_Questions = "https://anmolcoder.pythonanywhere.com/quiz/question/";
    String Server_Url_Comment_Read = "https://anmolcoder.pythonanywhere.com/imagefeed/comment/";
    String Server_Url_Quiz_Read = "https://anmolcoder.pythonanywhere.com/quiz/{id}";
    String Server_Url_Like_Read = "https://anmolcoder.pythonanywhere.com/imagefeed/like/{post_id}/";
    String Server_Url_User_Check_User_Read = "https://anmolcoder.pythonanywhere.com/user/";
    String Server_Url_User_Read = "https://anmolcoder.pythonanywhere.com/user/";
    public static MutableLiveData<List<Model_Image_Feed_list>> model_image_feed_listArrayList;
    public static MutableLiveData<Model_Image_Feed_list> image_feed_detail;
    public static MutableLiveData<List<Sponsor>> sponsorArrayList;
    public static MutableLiveData<List<Events>> eventsArrayList;
    public static MutableLiveData<Events> eventsRead_detail;
    public static MutableLiveData<List<Members_List>> member_listArrayList;
    public static MutableLiveData<List<User_List>> user_listArrayList;
    public static MutableLiveData<List<Quiz_List>> quiz_listArrayList;
    public static MutableLiveData<List<Quiz_Leaderboard_Results_List>> quiz_leaderboard_results_listArrayList;
    public static MutableLiveData<List<Quiz_Leaderboard_Results_Read>> quiz_leaderboard_results_readArrayList;
    public static MutableLiveData<Quiz_Questions> quiz_questions;
    public static MutableLiveData<Comment_Read> comment_read_details;
    public static MutableLiveData<List<Quiz_List>> quiz_readArrayList;
    public static MutableLiveData<Like_Read> like_read_details;
    public static MutableLiveData<User_Check_User_Read> user_check_user_read_details;
    public static MutableLiveData<User_List> user_read_details;


    public void FetchData() {
        model_image_feed_listArrayList = new MutableLiveData<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Server_Url_Image_Feed_list, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Model_Image_Feed_list> a1 = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        Log.e("retrieve", String.valueOf(response));

                        JSONObject jsonObject = response.getJSONObject(i);
                        a1.add(new Model_Image_Feed_list(jsonObject.getString("id"), jsonObject.getJSONObject("author").getString("username"), jsonObject.getString("photo"), jsonObject.getString("text"), jsonObject.getString("location"), jsonObject.getString("posted_on"), jsonObject.getString("number_of_likes"), jsonObject.getString("number_of_comments"), jsonObject.getString("post_comments")));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                model_image_feed_listArrayList.postValue(a1);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", String.valueOf(error));
                Toast.makeText(context, String.valueOf(error), Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);

    }


    public void getImage_Feed_Read(String id) {
        image_feed_detail = new MutableLiveData<>();
        JsonObjectRequest jsonobjectRequest = new JsonObjectRequest(Request.Method.GET, Server_Url_Image_Feed_Read + id, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // List<Model_Image_Feed_list> b1 = new ArrayList<>();

//
                try {
                    Log.e("ImageFeedRead", String.valueOf(response));
                    Model_Image_Feed_list item = new Model_Image_Feed_list(response.getString("id"), response.getJSONObject("author").getString("username"), response.getString("photo"), response.getString("text"), response.getString("location"), response.getString("posted_on"), response.getString("number_of_likes"), response.getString("number_of_comments"), response.getString("post_comments"));

                    image_feed_detail.postValue(item);


                } catch (JSONException e) {
                    Log.e("imgerror1", e.getMessage());
                    e.printStackTrace();
                }


            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("igerror", error.toString());
                    }
                });
        requestQueue.add(jsonobjectRequest);

//
//        StringRequest stringRequest  = new StringRequest(Request.Method.GET, Server_Url_Image_Feed_Read + id, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                List<Model_Image_Feed_list> b1 = new ArrayList<>();
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                Log.e("StringReq",String.valueOf(response));
//            }
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                });
//        requestQueue.add(stringRequest);

    }


    public void getSponsors() {
        sponsorArrayList = new MutableLiveData<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Server_Url_Sponsors, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Sponsor> a2 = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {

                    try {
                        Log.e("Sponsor", String.valueOf(response));
                        JSONObject jsonObject = response.getJSONObject(i);
                        a2.add(new Sponsor(jsonObject.getString("name"), jsonObject.getString("image"), jsonObject.getString("link"), jsonObject.getString("position"), jsonObject.getInt("priority")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                sponsorArrayList.postValue(a2);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }


    public void getEvents() {
        eventsArrayList = new MutableLiveData<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Server_Url_Events, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Events> a3 = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        Log.e("Events", String.valueOf(response));
                        JSONObject jsonObject = response.getJSONObject(i);
                        a3.add(new Events(jsonObject.getString("title"), jsonObject.getString("description"), jsonObject.getString("startTime"), jsonObject.getString("endTime"), jsonObject.getString("clubName"), jsonObject.getString("platform"), jsonObject.getString("image"), jsonObject.getString("regURL"), jsonObject.getInt("type")));
                    } catch (JSONException e) {
                        Log.e("EventError", String.valueOf(e.getMessage()));
                        e.printStackTrace();
                    }
                }
                eventsArrayList.postValue(a3);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }


    public void getEvents_Read(String title) {
        eventsRead_detail = new MutableLiveData<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Server_Url_EventsRead + title, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                // List<Events> b3 = new ArrayList<>();
                //  for (int i = 0; i < response.length(); i++) {
                try {
                    Log.e("EventsRead", String.valueOf(response));
                    Events evdetails = new Events(response.getString("title"), response.getString("description"), response.getString("startTime"), response.getString("endTime"), response.getString("clubName"), response.getString("platform"), response.getString("image"), response.getString("regURL"), response.getInt("type"));
                    eventsRead_detail.postValue(evdetails);


                } catch (JSONException e) {
                    Log.e("EventReadError", String.valueOf(e.getMessage()));
                    e.printStackTrace();
                }
                //  }


            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(jsonObjectRequest);
    }


    public void getMembers_List() {
        member_listArrayList = new MutableLiveData<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Server_Url_Member_List, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Members_List> a4 = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        Log.e("Member", String.valueOf(response));
                        JSONObject jsonObject = response.getJSONObject(i);
                        a4.add(new Members_List(jsonObject.getString("name"), jsonObject.getString("position"), jsonObject.getString("image")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                member_listArrayList.postValue(a4);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(jsonArrayRequest);
    }


    public void getUser_List() {
        user_listArrayList = new MutableLiveData<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Server_Url_User_List, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<User_List> a5 = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        Log.e("User", String.valueOf(response));
                        JSONObject jsonObject = response.getJSONObject(i);
                        a5.add(new User_List(jsonObject.getString("firebase"), jsonObject.getString("username"), jsonObject.getString("phone"), jsonObject.getString("email"), jsonObject.getString("name"), jsonObject.getString("instagramId"), jsonObject.getString("profileImage")));
                    } catch (JSONException e) {
                        Log.e("UserError", String.valueOf(e.getMessage()));
                        e.printStackTrace();
                    }
                }
                user_listArrayList.postValue(a5);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(jsonArrayRequest);
    }


    public void getQuiz_List() {
        quiz_listArrayList = new MutableLiveData<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Server_Url_Quiz_List, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Quiz_List> a6 = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        Log.e("QuizList", String.valueOf(response));
                        JSONObject jsonObject = response.getJSONObject(i);
                        a6.add(new Quiz_List(jsonObject.getString("id"), jsonObject.getString("name"), jsonObject.getString("count"), jsonObject.getString("sendCount"), jsonObject.getString("startTime"), jsonObject.getString("endTime")));

                    } catch (JSONException e) {
                        Log.e("QuizListError", String.valueOf(e.getMessage()));
                        e.printStackTrace();
                    }
                }
                quiz_listArrayList.postValue(a6);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(jsonArrayRequest);
    }


    public void getQuiz_Leaderboard_Results_List() {
        quiz_leaderboard_results_listArrayList = new MutableLiveData<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Server_Url_Quiz_Leaderboard_Results_List, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Quiz_Leaderboard_Results_List> a7 = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        Log.e("QuizLeaderboardResult", String.valueOf(response));
                        JSONObject jsonObject = response.getJSONObject(i);
                        a7.add(new Quiz_Leaderboard_Results_List(jsonObject.getInt("id"), jsonObject.getString("user"), jsonObject.getInt("score"), jsonObject.getString("timestamp")));
                    } catch (JSONException e) {
                        Log.e("LeaderboardError", String.valueOf(e.getMessage()));
                        e.printStackTrace();
                    }
                }
                quiz_leaderboard_results_listArrayList.postValue(a7);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        requestQueue.add(jsonArrayRequest);
    }


    public void getQuiz_Leaderboard_Results_Read(int id) {
        quiz_leaderboard_results_readArrayList = new MutableLiveData<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Server_Url_Quiz_Leaderboard_Results_Read + id, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Quiz_Leaderboard_Results_Read> a8 = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        Log.e("ResultsRead", String.valueOf(response));
                        JSONObject jsonObject = response.getJSONObject(i);
                        a8.add(new Quiz_Leaderboard_Results_Read(jsonObject.getInt("id"), jsonObject.getJSONObject("user").getString("username"), jsonObject.getJSONObject("user").getString("profileImage"), jsonObject.getInt("score"), jsonObject.getString("timestamp"), jsonObject.getString("quiz")));
                    } catch (JSONException e) {
                        Log.e("ResultsReadError", String.valueOf(e.getMessage()));
                        e.printStackTrace();
                    }
                }
                quiz_leaderboard_results_readArrayList.postValue(a8);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(jsonArrayRequest);
    }


    public void getQuiz_Questions(int id) {
        quiz_questions = new MutableLiveData<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Server_Url_Quiz_Questions + id, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // List<Quiz_Questions> a9 = new ArrayList<>();

                try {
                    Log.e("QuizQuestion", String.valueOf(response));
                    Quiz_Questions Question = new Quiz_Questions(response.getInt("id"), response.getString("text"), response.getString("image"), response.getString("option1"), response.getString("option2"), response.getString("option3"), response.getString("option4"), response.getInt("correct"), response.getInt("optionCount"), response.getInt("timeLimit"), response.getInt("marks"), response.getInt("negativeMarks"));
                    quiz_questions.postValue(Question);
                } catch (JSONException e) {
                    Log.e("QuizquesError", String.valueOf(e.getMessage()));
                    e.printStackTrace();
                }
            }


        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        NetworkResponse networkResponse = error.networkResponse;
                        Log.e("er", String.valueOf(networkResponse));
                    }
                });
        requestQueue.add(jsonObjectRequest);

    }

    public void getComment_Read(int comment_id) {
        comment_read_details = new MutableLiveData<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Server_Url_Comment_Read + comment_id, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //  List<Comment_Read> a10 = new ArrayList<>();

                try {
                    Log.e("Comment_Read", String.valueOf(response));
                    Comment_Read comment_read = new Comment_Read(response.getInt("id"), response.getJSONObject("author").getString("username"), response.getString("text"), response.getString("posted_on"));
                    comment_read_details.postValue(comment_read);
                } catch (JSONException e) {
                    Log.e("CommentError", String.valueOf(e.getMessage()));
                    e.printStackTrace();
                }


            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("err", error.toString());
                    }
                });
        requestQueue.add(jsonObjectRequest);
    }


    public void getQuiz_Read(String id) {
        quiz_readArrayList = new MutableLiveData<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Server_Url_Quiz_Read + id, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Quiz_List> a11 = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        Log.e("Quiz_read", String.valueOf(response));
                        JSONObject jsonObject = response.getJSONObject(i);
                        a11.add(new Quiz_List(jsonObject.getString("id"), jsonObject.getString("name"), jsonObject.getString("count"), jsonObject.getString("sendCount"), jsonObject.getString("startTime"), jsonObject.getString("endTime")));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                quiz_readArrayList.postValue(a11);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(jsonArrayRequest);
    }

    public void getLike_Read(String post_id) {
        like_read_details = new MutableLiveData<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Server_Url_Like_Read + post_id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Like_Read", String.valueOf(response));
                Like_Read like = new Like_Read();
                like_read_details.postValue(like);

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(stringRequest);
    }

    public void getUser_Check_User_Read(String firebase) {
        user_check_user_read_details = new MutableLiveData<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Server_Url_User_Check_User_Read + firebase, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                User_Check_User_Read check_user = new User_Check_User_Read();
                Log.e("CheckUser", String.valueOf(response));
                user_check_user_read_details.postValue(check_user);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

    public void getUser_Read(String firebase) {
        user_read_details = new MutableLiveData<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Server_Url_User_Read + firebase, null
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {
                    Log.e("UserRead", String.valueOf(response));
                    User_List user_read = new User_List(response.getString("firebase"), response.getString("username"), response.getString("phone"), response.getString("email"), response.getString("name"), response.getString("instagramId"), response.getString("profileImage"));
                    user_read_details.postValue(user_read);
                } catch (JSONException e) {
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
//    final String title, final String description, final String startTime, final String endTime,final String clubName,final String platform,final String image,final String regUrl,final int type

    public void PostUser(String firebase, String username, String phone, String email, String name, String instagramId, String profileImage) {
     if(firebase.isEmpty()){
         Toast.makeText(context,"plis fill all the details",Toast.LENGTH_SHORT).show();
         Log.e("empty","plis fill details");
     }
     else if(username.isEmpty()){
         Log.e("emptyuser","fill user name");

     }
     else if(phone.isEmpty()){
         Log.e("empty phone","fill phone no");
     }
     else if(email.isEmpty()){
         Log.e("empty email","fill email");
     }
     else if(name.isEmpty()){
         Log.e("name","plis fill name");
     }
     else if(instagramId.isEmpty()){
         Log.e("emptyInsta","fill insta");
     }
     else if(profileImage.isEmpty()){
         Log.e("No Profile","Upload profile image");
     }
      else {
         StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://anmolcoder.pythonanywhere.com/user/", new Response.Listener<String>() {
             @Override
             public void onResponse(String response) {
                 Log.e("postevents", String.valueOf(response));
             }
         },
                 new Response.ErrorListener() {
                     @Override
                     public void onErrorResponse(VolleyError error) {
                         Log.e("RErrorPost", error.toString());
                     }
                 }) {
             @Nullable
             @Override
             protected Map<String, String> getParams() throws AuthFailureError {
                 Map<String, String> params = new HashMap<String, String>();
                 params.put("firebase", firebase);
                 params.put("username", username);
                 params.put("phone", phone);
                 params.put("email", email);
                 params.put("name", name);
                 params.put("instagramId", instagramId);
                 params.put("profileImage", profileImage);

                 return params;


             }
         };
         requestQueue.add(stringRequest);
     }

    }

    public void PutUser(String firebase, String username, String phone, String email, String name, String instagramId, String profileImage) {


        StringRequest stringRequest = new StringRequest(Request.Method.PUT, "https://anmolcoder.pythonanywhere.com/user/"+firebase, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("PutUserdetails", String.valueOf(response));
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("ErrorUserPut", error.toString());
                    }
                }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("firebase", firebase);
                params.put("username", username);
                params.put("phone", phone);
                params.put("email", email);
                params.put("name", name);
                params.put("instagramId", instagramId);
                params.put("profileImage", profileImage);

                return params;


            }
        };
        requestQueue.add(stringRequest);


    }
























//       public void imageFeedcreate(String  photo , String text , String location){
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://anmolcoder.pythonanywhere.com/imagefeed/", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.e("CreateFeed",String.valueOf(response));
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//Log.e("FErr",error.getMessage());
//            }
//        }
//        ){
//            @Nullable
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String,String > params = new HashMap<String ,String >();
//                params.put("photo",Uri.encode(photo.toString()));
//                params.put("text",text);
//                params.put("location",location);
//                return params;
//            }
//        };
//        requestQueue.add(stringRequest);
//
//       }


}
