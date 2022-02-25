package com.nith.hillfair2k22.screens.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.adapters.CustomAdapter;
import com.nith.hillfair2k22.adapters.NewCustomAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CommentUserFeedFragment#} factory method to
 * create an instance of this fragment.
 */
public class CommentUserFeedFragment extends AppCompatActivity {
    ImageView img;
    ImageView img2;
    ToggleButton togglebtn;
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public CommentUserFeedFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment CommentUserFeedFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static CommentUserFeedFragment newInstance(String param1, String param2) {
//        CommentUserFeedFragment fragment = new CommentUserFeedFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    UserComments c1=new UserComments("abc","xyz");
    UserComments c2=new UserComments("abc","xyz");
    UserComments c3=new UserComments("abc","xyz");
    UserComments c4=new UserComments("abc","xyz");
    UserComments c5=new UserComments("abc","xyz");
    UserComments c6=new UserComments("abc","xyz");
    UserComments [] usercomments={c1,c2,c3,c4,c5,c6};
    RecyclerView recyclerView;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

//    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_comment_user_feed, container, false);
        recyclerView=view.findViewById(R.id.user_comment_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        NewCustomAdapter ad=new NewCustomAdapter(usercomments);
        recyclerView.setAdapter(ad);

        return inflater.inflate(R.layout.fragment_comment_user_feed, container, false);
    }
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_comment_user_feed);
    Intent intent=getIntent();
    boolean like=intent.getBooleanExtra("post_like",false);
    togglebtn=findViewById(R.id.heart_icon);
    togglebtn.setChecked(like);
    Log.e( "onCreate: ",like+"" );
    img2=findViewById(R.id.user_comment_post_comment_icon);

    img2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(CommentUserFeedFragment.this, "Comment added", Toast.LENGTH_SHORT).show();
        }
    });
    img=findViewById(R.id.user_comment_message_icon);
    img.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
    // Inflate the layout for this fragment

    recyclerView=findViewById(R.id.user_comment_recyclerview);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    NewCustomAdapter ad=new NewCustomAdapter(usercomments);
    recyclerView.setAdapter(ad);



}

}