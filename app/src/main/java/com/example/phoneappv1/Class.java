package com.example.phoneappv1;

public class Class {
    String subject = "";
    public Class(String c){
        subject = c;
        int x = 1;
        boolean bool = true;
        while(bool) {
            try {
                Question q = new Question(subject, x);
            } catch (Exception e) {

            }
        }
    }


}
