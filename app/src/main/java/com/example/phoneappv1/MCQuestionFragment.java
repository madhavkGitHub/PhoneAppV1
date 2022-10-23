package com.example.phoneappv1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class MCQuestionFragment extends Fragment implements View.OnClickListener {
    Button[] buttons = new Button[4];
    int[] ids = new int[]{R.id.btnA, R.id.btnB, R.id.btnC, R.id.btnD};
    String[] name = new String[]{"A", "B", "C", "D"};
    Button submit;
    int curr_select = -1;
    TextView q;
    Question question;
    boolean submitted = false, feedback;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mc_question, container, false);
    }

    public static MCQuestionFragment newInstance(Question q, int num, boolean fb) {
        Bundle args = new Bundle();
        args.putSerializable("question", q);
        args.putInt("probNum", num);
        args.putBoolean("feedback", fb);
        MCQuestionFragment fragment = new MCQuestionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        q = view.findViewById(R.id.txtQuestion);
        submit = view.findViewById(R.id.btnSubmit);
        submit.setOnClickListener(this);

        Bundle args = getArguments();
        question = (Question) args.get("question");
        int probNum = args.getInt("probNum");
        feedback = args.getBoolean("feedback");

        q.setText(probNum + ") " + question.getQ());
        String[] ops = question.getOptions();
        for (int i = 0; i < 4; i++) {
            buttons[i] = view.findViewById(ids[i]);
            buttons[i].setOnClickListener(this);
            buttons[i].setText(name[i] + ") " +  ops[i]);
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (submitted) {
            if (id == R.id.btnSubmit) {
                ((QuestionSequence) getActivity()).nextQuestion();
            }
        }
        else if (id == R.id.btnSubmit) {
            if (curr_select == -1) Toast.makeText(getContext(), "Select an Answer", Toast.LENGTH_SHORT).show();
            else {
                if (!feedback) {
                    question.check(curr_select);
                    ((QuestionSequence) getActivity()).nextQuestion();
                } else {
                    submitted = true;
                    if (!question.check(curr_select)) {
                        buttons[curr_select].setBackgroundColor(ContextCompat.getColor(getContext(), R.color.incorrect));
                    }
                    buttons[question.getAns()].setBackgroundColor(ContextCompat.getColor(getContext(), R.color.correct));
                    submit.setText("Continue");
                }
            }
        } else {
            int select = 0;
            for (int i = 0; i < ids.length; i++) if (ids[i] == id) select = i;

            if (curr_select != -1) buttons[curr_select].setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
            buttons[select].setBackgroundColor(getResources().getColor(R.color.btnSelect));
            curr_select = select;
        }
    }
}
