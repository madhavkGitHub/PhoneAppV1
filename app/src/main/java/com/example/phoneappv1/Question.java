package com.example.phoneappv1;

import android.os.Parcelable;

import java.util.*;
import java.io.*;


public class Question  implements Serializable {

    private String q; // question, subject, current progress
    private String[] options = new String[4]; // list of four possible answers
    private int ans, dif; // index of correct answer, difficulty, question number
    private boolean ansCorrect = false;

    public Question(String q, String[] options, int ans, int dif) {
        this.q = q;
        this.options = options;
        this.ans = ans;
        this.dif = dif;
    }

    public boolean check(int answer) {
        ansCorrect = ans == answer;
        return ansCorrect;
    }

    public int getDif() {
        return dif;
    }

    public String[] getOptions() {
        return options;
    }

    public int getAns() {
        return ans;
    }

    public String getQ(){
        return q;
    }

    public boolean isAnsCorrect() {
        return ansCorrect;
    }
}