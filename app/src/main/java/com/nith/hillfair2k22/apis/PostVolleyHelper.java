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
import com.nith.hillfair2k22.MainActivity;
import com.nith.hillfair2k22.Models.LikeList;
import com.nith.hillfair2k22.Models.NewCommentRead;
import com.nith.hillfair2k22.Models.Posts;
import com.nith.hillfair2k22.Models.User_Serializer_For_ImageFeed;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PostVolleyHelper {
    Context context;
    RequestQueue requestQueue;
    public PostVolleyHelper(Context context){
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
    }

//     MainActivityCode;
//    PostVolleyHelper p1 = new PostVolleyHelper(MainActivity.this);
//p1.getLikeCountList("7a1d6d27-8306-4ebd-b74d-8ca2a68e1149");
//    final androidx.lifecycle.Observer<LikeList> observer4 = new androidx.lifecycle.Observer<LikeList>() {
//        @Override
//        public void onChanged(LikeList likeList) {
//            Log.e("abcdef",String.valueOf(likeList));
//            Log.e("idf123",String.valueOf(likeList.getCount()));
//            Log.e("iddfgd12345",String.valueOf(likeList.getNext()));
//            Log.e("idgsd23",String.valueOf(likeList.getPrevious()));
//            Log.e("eddf",String.valueOf(likeList.getResult().get(0).getUsername()));
//        }
//    };
//        likeList.observe(this,observer4);

    // MODELS USED -> Posts,NewCommentRead,User_Serializer_For_ImageFeed,LikeList;







    public static MutableLiveData<List<Posts>> PostArrayList;
    public void getPost(){
        PostArrayList  = new MutableLiveData<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://anmolcoder.pythonanywhere.com/imagefeed/", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Posts> plist = new ArrayList<>();
                for(int i=0;i<response.length();i++){
                    try {
                        Log.e("Res",String.valueOf(response));
                        JSONObject jsonObject = response.getJSONObject(i);
                        String  id  = jsonObject.getString("id");

                        JSONObject userserial = jsonObject.getJSONObject("author");
                        Log.e("userser",String.valueOf(userserial));
                        String username = userserial.getString("username");
                        User_Serializer_For_ImageFeed author = new User_Serializer_For_ImageFeed(username);
                        Log.e("author",String.valueOf(author.getUsername()));
                        String photo = jsonObject.getString("photo");
                        String text = jsonObject.getString("text");
                        String location = jsonObject.getString("location");
                        String posted_on = jsonObject.getString("posted_on");
                        String number_of_likes = jsonObject.getString("number_of_likes");
                        String number_of_comments = jsonObject.getString("number_of_comments");
                        String post_comments = jsonObject.getString("number_of_comments");
                        plist.add(new Posts(id,author,photo,text,location,posted_on,number_of_likes,number_of_comments,post_comments));
                        Log.e("Plists",String.valueOf(plist));



                    } catch (JSONException e) {
                        Log.e("String",String.valueOf(e));
                        e.printStackTrace();
                    }

                }
                PostArrayList.postValue(plist);

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(jsonArrayRequest);
    }

    public void createPost(String firebase){
        JSONObject jsonbody = new JSONObject();
        try {

            jsonbody.put("photo","https://www.pexels.com/photo/a-photography-of-a-man-standing-on-a-tree-3680219/.jpeg");
            jsonbody.put("text","RohitYadav");
            jsonbody.put("location","Jaipur");
           // jsonbody.put("firebase",12545);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://anmolcoder.pythonanywhere.com/imagefeed/"+firebase+"/", jsonbody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
         Log.e("Resoi",String.valueOf(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);

    }
    public static MutableLiveData<NewCommentRead> commentRead;
    public void getCommentRead(String comment_id){
        commentRead = new MutableLiveData<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://anmolcoder.pythonanywhere.com/imagefeed/comment/"+comment_id+"/", null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.e("CommentRead",String.valueOf(response));
                    int id = response.getInt("id");
                    JSONObject userSerializer = response.getJSONObject("author");
                    String Username = userSerializer.getString("username");
                    User_Serializer_For_ImageFeed author = new User_Serializer_For_ImageFeed(Username);
                    String text = response.getString("text");
                    String posted_on = response.getString("posted_on");
                    NewCommentRead item = new NewCommentRead(id,author,text,posted_on);
                    commentRead.postValue(item);

                } catch (JSONException e) {
                    Log.e("CommentExcept",e.getMessage());
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             Log.e("CommentREadError",error.getMessage());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
    public void CommentPost(String firebase ,String post_id,String text){
        JSONObject jsonbody = new JSONObject();
        try {
            jsonbody.put("text",text);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://anmolcoder.pythonanywhere.com/imagefeed/comment/"+post_id+"/"+firebase+"/", jsonbody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
               Log.e("CreateComment",String.valueOf(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
           Log.e("CommenteRror",error.getMessage());
            }
        });
        requestQueue.add(jsonObjectRequest);


    }

    public void UpdateComment(String comment_id ,String text){
        JSONObject jsonbody = new JSONObject();
        try {
            jsonbody.put("text",text);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, "https://anmolcoder.pythonanywhere.com/imagefeed/comment/"+comment_id+"/", jsonbody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("UpdateComment",String.valueOf(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("UpdateCommenteRror",error.getMessage());
            }
        });
        requestQueue.add(jsonObjectRequest);


    }

    public void partialCommentUpdate(String comment_id ,String text){
        JSONObject jsonbody = new JSONObject();
        try {
            jsonbody.put("text",text);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, "https://anmolcoder.pythonanywhere.com/imagefeed/comment/"+comment_id+"/", jsonbody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("Updatepartial",String.valueOf(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("partialCommenteRror",error.getMessage());
            }
        });
        requestQueue.add(jsonObjectRequest);


    }


    public void deleteComment(String comment_id){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, "https://anmolcoder.pythonanywhere.com/imagefeed/comment/"+comment_id+"/", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
             Log.e("Del","Deleted");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);

    }
    public void likeRead(String firebase,String post_id){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://anmolcoder.pythonanywhere.com/imagefeed/like/"+post_id+"/"+firebase, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
               Log.e("LikeRead",String.valueOf(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorLike",error.getMessage());

            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    public static MutableLiveData<LikeList> likeList;
    public void getLikeCountList(String post_id){
        likeList = new MutableLiveData<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "http://anmolcoder.pythonanywhere.com/imagefeed/"+post_id+"/get-likers/", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.e("likelist",String.valueOf(response));
                    int count = response.getInt("count");
                    String next = response.getString("next");
                    String previous = response.getString("previous");
                    JSONArray resultarray = new JSONArray();
                    resultarray = response.getJSONArray("results");
                    List<User_Serializer_For_ImageFeed> results = new ArrayList<>();
                    for(int i=0;i<resultarray.length();i++){
                     JSONObject jsonObject = resultarray.getJSONObject(i);
                     String username = jsonObject.getString("username");
                     results.add(new User_Serializer_For_ImageFeed(username));
                    }
                    LikeList item  =new LikeList(count,next,previous,results);
                    likeList.postValue(item);



                } catch (JSONException e) {
                    Log.e("exclist",e.getMessage());
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                  Log.e("ErorListLike",error.getMessage());
            }
        });
        requestQueue.add(jsonObjectRequest);


    }




}
