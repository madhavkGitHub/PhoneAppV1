package com.example.phoneappv1;

import android.content.res.AssetManager;
import android.widget.Toast;

import java.util.*;
import java.io.*;

public class QuestionReader implements Serializable {

    HashMap<Integer, ArrayList<Question>> qHashMap = new HashMap<Integer, ArrayList<Question>>();
    ArrayList<Question> qlist = new ArrayList<Question>();

    public QuestionReader(BufferedReader infile) throws IOException {
        Question q;
        String question = "";

        int ans, dif;

        while (true) {
            question = infile.readLine();
            if (question == null) break;
            ans = infile.readLine().charAt(0) - 65;
            String[] options = new String[4];
            options[0] = infile.readLine();
            options[1] = infile.readLine();
            options[2] = infile.readLine();
            options[3] = infile.readLine();
            dif = Integer.parseInt(infile.readLine());
            q = new Question(question, options, ans, dif);

            qlist.add(q);
            if (qHashMap.get(q.getDif()) == null) qHashMap.put(dif, new ArrayList<>());
            qHashMap.get(q.getDif()).add(q);

        }
    }

    public HashMap<Integer, ArrayList<Question>> getqHashMap() {
        return qHashMap;
    }

    public ArrayList<Question> getQlist() {
        return qlist;
    }

    public Question getQuestion(int n) { return qlist.get(n);}

    public ArrayList<Question> getQuestionDif(int dif) {return qHashMap.get(dif);}

}
