package com.example.phoneappv1;

import java.util.*;
import java.io.*;

public class QuestionReader {

    HashMap<Integer, ArrayList<Question>> qHashMap = new HashMap<Integer, ArrayList<Question>>();
    ArrayList<Question> qlist = new ArrayList<Question>();
    String filename = null;
    Boolean fileExists = false;


    public QuestionReader(String file) {
        filename = file;
        Scanner infile = null;
        try {
            infile = new Scanner(new File(filename + ".txt"));
            fileExists = true;
        }
        catch (Exception e) {
            qlist = null;
            System.out.println("file not found");
        }

        Question q;
        String question = "";
        String[] options = new String[4];
        int ans;
        char c;
        int dif;
        ArrayList<Question> diflist = new ArrayList<Question>();

        while (fileExists && infile.hasNextLine()) {

            question = infile.nextLine();
            c = infile.nextLine().toUpperCase().charAt(0);
            ans = c;
            options[0] = infile.nextLine();
            options[1] = infile.nextLine();
            options[2] = infile.nextLine();
            options[3] = infile.nextLine();
            dif = Integer.parseInt(infile.nextLine());
            q = new Question(question, options, ans - 65, dif);
            qlist.add(q);
            if (qHashMap.get(q.getDif()) != null)
                diflist = qHashMap.get(q.getDif());
            diflist.add(q);
            qHashMap.put(dif,diflist);
            diflist.removeAll(diflist);
        }
    }

    public Question getQuestion(int dif) { return qlist.get(dif);}

}
