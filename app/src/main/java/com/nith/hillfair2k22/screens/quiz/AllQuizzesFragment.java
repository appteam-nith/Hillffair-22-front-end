package com.nith.hillfair2k22.screens.quiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.nith.hillfair2k22.Models.Events;
import com.nith.hillfair2k22.Models.Quiz_List;
import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.adapters.EventAdapter;
import com.nith.hillfair2k22.adapters.QuizAdapter;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;


public class AllQuizzesFragment extends Fragment {


    private RecyclerView quizRV;

    private QuizAdapter quizAdapter;
    private ArrayList<Quiz_List> quizListArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_quizzes, container, false);

        quizRV = view.findViewById(R.id.all_quiz_RV);

        quizListArrayList = new ArrayList<>();

        getQuizData();
        buildQuizRV();



        return view;
    }

    private void getQuizData() {
        for (int i = 0; i < 19; i++) {
            quizListArrayList.add(new Quiz_List("id", "quiz_name", "count", "sendCount", "startTime","endTime"));
        }
    }

    private void buildQuizRV() {

        quizAdapter = new QuizAdapter(quizListArrayList, getActivity());

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        quizRV.setHasFixedSize(true);

        quizRV.setLayoutManager(manager);

        // <-----ANIMATIONS---->

        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(quizAdapter);
        animationAdapter.setDuration(1000);
        animationAdapter.setInterpolator(new AccelerateDecelerateInterpolator());
        animationAdapter.setFirstOnly(false);
        quizRV.setAdapter(animationAdapter);



    }
}