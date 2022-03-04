package com.nith.hillfair2k22.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nith.hillfair2k22.Models.Events;
import com.nith.hillfair2k22.Models.Quiz_List;
import com.nith.hillfair2k22.R;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {

    private ArrayList<Quiz_List> quizListArrayList ;
    private Context context;

    public QuizAdapter(ArrayList<Quiz_List> quizListArrayList, Context context) {
        this.quizListArrayList = quizListArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_quiz_item, parent, false);
        return new QuizViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        Quiz_List quiz = quizListArrayList.get(position);
        holder.quizNo.setText("Quiz "+(position+1));
        holder.quizClub.setText(quiz.getName());
        holder.quizDate.setText(quiz.getStartTime());
    }

    @Override
    public int getItemCount() {
        return quizListArrayList.size();
    }

    public class QuizViewHolder extends RecyclerView.ViewHolder {

        private TextView quizNo, quizClub, quizDate;
        public QuizViewHolder(@NonNull View itemView) {
            super(itemView);

            quizNo=itemView.findViewById(R.id.quiz_name);
            quizClub=itemView.findViewById(R.id.Club_quiz_name);
            quizDate=itemView.findViewById(R.id.quiz_date_time);
        }
    }
}
