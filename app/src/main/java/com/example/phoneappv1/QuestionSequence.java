package com.example.phoneappv1;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class QuestionSequence extends AppCompatActivity implements View.OnClickListener {
    QuestionReader qr;
    int qNum = 0, total, numCorr = 0, curr_dif, curr_prog = -1;
    boolean fb;
    Question curr_ques;
    int[] diff_tracker = new int[]{0, 0, 0, 0, 0, 0};
    ProgressBar progressBar;
    Button exit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_sequence);
        Bundle b = getIntent().getExtras();

        qr = (QuestionReader) b.get("QuestionReader");
        total = b.getInt("total");
        curr_dif = b.getInt("diff");
        fb = b.getBoolean("feedback");
        String subject = b.getString("subject");
        ((TextView) findViewById(R.id.txtSubject)).setText(subject);
        progressBar = (ProgressBar) findViewById(R.id.completeBar);
        progressBar.setMax(total);

        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(this);

        nextQuestion();
    }

    public void nextQuestion() {
        curr_prog++;
        progressBar.setProgress(curr_prog);
        if (curr_ques != null) {
            if (curr_ques.isAnsCorrect()) {
                numCorr++;
                curr_dif = Math.min(curr_dif + 1, 5);
            } else {
                curr_dif = Math.max(curr_dif - 1, 1);
            }
        }
        qNum++;
        if (qNum > total) showEndScreen();
        else {
            ArrayList<Question> qs = qr.getQuestionDif(curr_dif);
            curr_ques = qs.get(diff_tracker[curr_dif]++);
            if (diff_tracker[curr_dif] >= qs.size()) diff_tracker[curr_dif] = 0;

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragmentContainerView, MCQuestionFragment.newInstance(curr_ques, qNum, fb));
            ft.commit();
        }
    }

    public void showEndScreen() {
        setContentView(R.layout.finish_screen);
        TextView corr = (TextView) findViewById(R.id.textView2), incorr = (TextView) findViewById(R.id.textView3);
        corr.setText(numCorr + "");
        incorr.setText((total - numCorr) + "");
        Button cont = (Button) findViewById(R.id.button);
        cont.setOnClickListener(this);
        RatingBar rb = (RatingBar) findViewById(R.id.ratingBar2);
        rb.setRating(((float) numCorr) * (float) 5.0 / total);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
