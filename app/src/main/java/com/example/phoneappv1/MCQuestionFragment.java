package com.example.phoneappv1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class MCQuestionFragment extends Fragment implements View.OnClickListener {
    Button A, B, C, D, submit, curr_select;
    TextView question;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mc_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        A = view.findViewById(R.id.btnA); B = view.findViewById(R.id.btnB); C = view.findViewById(R.id.btnC); D = view.findViewById(R.id.btnD);
        submit = view.findViewById(R.id.btnSubmit);
        question = view.findViewById(R.id.txtQuestion);
        A.setOnClickListener(this);
        B.setOnClickListener(this);
        C.setOnClickListener(this);
        D.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnA:
                if (curr_select != null) curr_select.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                A.setBackgroundColor(getResources().getColor(R.color.btnSelect));
                curr_select = A;
                break;
            case R.id.btnB:
                if (curr_select != null) curr_select.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                B.setBackgroundColor(getResources().getColor(R.color.btnSelect));
                curr_select = B;
                break;
            case R.id.btnC:
                if (curr_select != null) curr_select.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                C.setBackgroundColor(getResources().getColor(R.color.btnSelect));
                curr_select = C;
                break;
            case R.id.btnD:
                if (curr_select != null) curr_select.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                D.setBackgroundColor(getResources().getColor(R.color.btnSelect));
                curr_select = D;
                break;

        }
    }
}
