package com.nith.hillfair2k22.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.screens.quiz.QuizStandingsFragment;

public class NewQuizActivity extends AppCompatActivity {

    private CardView LeaderBoardCard, AnsDetailsCard, QCard, OptionC_Card, OptionB_Card, OptionA_Card, OptionD_Card;
    private TextView NxtBtn;

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_quiz);

        LeaderBoardCard=findViewById(R.id.score_quiz);
        AnsDetailsCard = findViewById(R.id.answer_details_quiz);
        QCard = findViewById(R.id.quiz_item_question);
        OptionC_Card = findViewById(R.id.option_quiz_a);
        OptionB_Card = findViewById(R.id.option_quiz_b);
        OptionA_Card = findViewById(R.id.option_quiz_c);
        OptionD_Card = findViewById(R.id.option_quiz_d);

        NxtBtn = findViewById(R.id.next_quiz_btn);

        LeaderBoardCard.setOnClickListener(view -> {

            LeaderBoardCard.setVisibility(View.GONE);
            AnsDetailsCard.setVisibility(View.GONE);
            QCard.setVisibility(View.GONE);
            OptionC_Card.setVisibility(View.GONE);
            OptionB_Card.setVisibility(View.GONE);
            OptionA_Card.setVisibility(View.GONE);
            OptionD_Card.setVisibility(View.GONE);
            NxtBtn.setVisibility(View.GONE);


            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.quiz_Activity_container,new QuizStandingsFragment()).commit();
        });
    }

    @Override
    public void onBackPressed() {

        Fragment fragment=fragmentManager.findFragmentById(R.id.quiz_Activity_container);
        if (fragment!=null){
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();

            LeaderBoardCard.setVisibility(View.VISIBLE);
            AnsDetailsCard.setVisibility(View.VISIBLE);
            QCard.setVisibility(View.VISIBLE);
            OptionC_Card.setVisibility(View.VISIBLE);
            OptionB_Card.setVisibility(View.VISIBLE);
            OptionA_Card.setVisibility(View.VISIBLE);
            OptionD_Card.setVisibility(View.VISIBLE);
            NxtBtn.setVisibility(View.VISIBLE);
        }else {
            super.onBackPressed();

        }
    }
}