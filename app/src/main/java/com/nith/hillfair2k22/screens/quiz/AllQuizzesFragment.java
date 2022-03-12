package com.nith.hillfair2k22.screens.quiz;

import static com.nith.hillfair2k22.apis.EventsVolleyHelper.eventList;
import static com.nith.hillfair2k22.apis.VolleyHelper.quiz_listArrayList;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.nith.hillfair2k22.Models.Events;
import com.nith.hillfair2k22.Models.Quiz_List;
import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.adapters.EventAdapter;
import com.nith.hillfair2k22.adapters.QuizAdapter;
import com.nith.hillfair2k22.apis.EventsVolleyHelper;
import com.nith.hillfair2k22.apis.VolleyHelper;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;


public class AllQuizzesFragment extends Fragment {


    private RecyclerView quizRV;

    private QuizAdapter quizAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_quizzes, container, false);

        quizRV = view.findViewById(R.id.all_quiz_RV);




        VolleyHelper volleyHelper = new VolleyHelper(getContext());
        volleyHelper.getQuiz_List();
        final androidx.lifecycle.Observer<List<Quiz_List>> observer = new androidx.lifecycle.Observer<List<Quiz_List>>() {
            @Override
            public void onChanged(List<Quiz_List> quiz_lists) {
                Log.e("abcd43", String.valueOf(quiz_lists));
                for (int i = 0; i < quiz_lists.size(); i++) {
                    Log.e("nnn", quiz_lists.get(i).getClubName());
                }

//                List onlyEventList = new ArrayList();
//
//                for (int i = 0; i < eventsList.size(); i++) {
//                    if (eventsList.get(i).getType() == 0) {
//                        onlyEventList.add(eventsList.get(i));
//                    }
//                }

                quizAdapter = new QuizAdapter((ArrayList<Quiz_List>) quiz_lists, getActivity());

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
        };
        quiz_listArrayList.observe(getActivity(), observer);



        return view;
    }

//    private void getQuizData() {
//        for (int i = 0; i < 19; i++) {
//            quizListArrayList.add(new Quiz_List("id", "quiz_name", "count", "sendCount", "startTime","endTime"));
//        }
//    }

//    private void buildQuizRV() {
//
//        quizAdapter = new QuizAdapter(quizListArrayList, getActivity());
//
//        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
//        quizRV.setHasFixedSize(true);
//
//        quizRV.setLayoutManager(manager);
//
//        // <-----ANIMATIONS---->
//
//        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(quizAdapter);
//        animationAdapter.setDuration(1000);
//        animationAdapter.setInterpolator(new AccelerateDecelerateInterpolator());
//        animationAdapter.setFirstOnly(false);
//        quizRV.setAdapter(animationAdapter);
//
//
//
//    }
}