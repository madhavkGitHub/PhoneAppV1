package com.example.phoneappv1;

import android.content.res.AssetManager;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class QuestionSequence extends AppCompatActivity implements View.OnClickListener {
    QuestionReader qr;
    int qNum = 0, total, numCorr = 0, curr_dif = 3;
    Question curr_ques;
    int[] diff_tracker = new int[]{0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle b = getIntent().getExtras();

        qr = (QuestionReader) b.get("QuestionReader");
        total = b.getInt("total");
        nextQuestion();
    }

    public void nextQuestion() {
        if (curr_ques != null) {
            if (curr_ques.isAnsCorrect()) {
                numCorr++;
                curr_dif = Math.min(curr_dif + 1, 5);
            } else {
                curr_dif = Math.max(curr_dif - 1, 1);
            }
        }
        qNum++;
        if (qNum == total) finish();
        ArrayList<Question> qs = qr.getQuestionDif(curr_dif);
        curr_ques = qs.get(diff_tracker[curr_dif]++);
        if (diff_tracker[curr_dif] >= qs.size()) diff_tracker[curr_dif] = 0;

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainerView, MCQuestionFragment.newInstance(curr_ques, qNum));
        ft.commit();
    }
    @Override
    public void onClick(View view) {
        return;
    }
}
