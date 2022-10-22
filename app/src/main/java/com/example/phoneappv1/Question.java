package com.example.phoneappv1;

import java.util.*;
import java.io.*;


public class Question {

    public String q;
    public String[] options = new String[4]; // list of four possible answers
    public int ans; // index of correct answer
    public int dif;

    public Question(String question, String[] o, int a, int d) {
        q = question;
        options = o;
        ans = a;
        dif = d;
    }

    public boolean check_madav_way(String answer) {

        if (answer.equalsIgnoreCase(options[ans]))
            return true;

        return false;
    }

    public void setDif(int diff) {
        dif = diff;
    }

    public int getDif() {
        return dif;
    }

    public String[] getOptions() {
        return options;
    }

    public String getAns() {
        return options[ans];
    }

    public String getQ(){
        return q;
    }
}