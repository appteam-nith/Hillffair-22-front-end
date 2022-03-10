package com.nith.hillfair2k22.screens.quiz;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Toast;

import com.nith.hillfair2k22.Models.Events;
import com.nith.hillfair2k22.Models.Quiz_Leaderboard_Results_Read;
import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.adapters.EventAdapter;
import com.nith.hillfair2k22.adapters.LeaderboardAdapter;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;


public class QuizStandingsFragment extends Fragment {

    private RecyclerView LeaderboardRV;

    private LeaderboardAdapter leaderboardAdapter;
    private ArrayList<Quiz_Leaderboard_Results_Read> LBArrayList;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//
//        OnBackPressedCallback callback = new OnBackPressedCallback(true ) {
//            @Override
//            public void handleOnBackPressed() {
////                Toast.makeText(getActivity(), "Back pressed", Toast.LENGTH_SHORT).show();
//
//            }
//        };
//        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz_standings, container, false);

        LeaderboardRV = view.findViewById(R.id.leader_board_RV);

        LBArrayList = new ArrayList<>();

        getLB_Data();

        buildLB_RV();
        return view;

    }

    private void buildLB_RV() {

        leaderboardAdapter = new LeaderboardAdapter(LBArrayList, getActivity());

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        LeaderboardRV.setHasFixedSize(true);

        LeaderboardRV.setLayoutManager(manager);

        // <-----ANIMATIONS---->

        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(leaderboardAdapter);
        animationAdapter.setDuration(1000);
        animationAdapter.setInterpolator(new AccelerateDecelerateInterpolator());
        animationAdapter.setFirstOnly(false);
        LeaderboardRV.setAdapter(animationAdapter);


    }

    private void getLB_Data() {

        for (int i = 0; i < 19; i++) {
            LBArrayList.add(new Quiz_Leaderboard_Results_Read(i, "Name", "https://media.geeksforgeeks.org/img-practice/banner/dsa-self-paced-thumbnail.png", i, "timestamp", "quiz  "));
        }
    }
}