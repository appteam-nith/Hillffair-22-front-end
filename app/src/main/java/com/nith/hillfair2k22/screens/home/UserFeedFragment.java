package com.nith.hillfair2k22.screens.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.adapters.CustomAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserFeedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */




public class UserFeedFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserFeedFragment() {
        // Required empty public constructor
    }

    Contact o1=new Contact("a1","b1");
    Contact o2=new Contact("a1","b1");
    Contact o3=new Contact("a1","b1");
    Contact o4=new Contact("a1","b1");
    Contact o5=new Contact("a1","b1");
    Contact o6=new Contact("a1","b1");
    Contact o7=new Contact("a1","b1");
    Contact o8=new Contact("a1","b1");
    Contact o9=new Contact("a1","b1");
    Contact [] contacts={o1,o2,o3,o4,o5,o6,o7,o8,o9};
    RecyclerView recyclerView;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserFeedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserFeedFragment newInstance(String param1, String param2) {
        UserFeedFragment fragment = new UserFeedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_user_feed, container, false);
        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        CustomAdapter ad=new CustomAdapter(contacts);
        recyclerView.setAdapter(ad);
        
        return view;
    }
}