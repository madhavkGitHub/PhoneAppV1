package com.example.phoneappv1;

import java.util.*;
import java.io.*;


public class Question {

    public String q;
    public String[] options = new String[4]; // list of four possible answers
    public int ans; // index of correct answer
    public int dif;

    public Question(String subCategory, int questionNumber) throws IOException {

        String folder = subCategory.substring(0,1).toUpperCase() + subCategory.substring(1);
        String file = folder + "Question" + Integer.toString(questionNumber);
        String path = "";
        String location = path + "\\" + folder + "\\" + file;
        Scanner scanner = new Scanner(new File(location));
        q = scanner.nextLine();
        ans = "ABCD".indexOf(scanner.nextLine());
        options[0] = scanner.nextLine();
        options[1] = scanner.nextLine();
        options[2] = scanner.nextLine();
        options[3] = scanner.nextLine();
        dif = scanner.nextInt();
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