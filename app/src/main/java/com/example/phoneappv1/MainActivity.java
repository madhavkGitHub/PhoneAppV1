package com.example.phoneappv1;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int qNum = 1, total = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        try {
            Intent intent = new Intent(this, QuestionSequence.class);
            Bundle b = new Bundle();
            System.out.println("hi");

            BufferedReader br = new BufferedReader(new InputStreamReader(this.getAssets().open("Biology" + ".txt")));

            QuestionReader subQues = new QuestionReader(br);

            b.putSerializable("QuestionReader", subQues);
            b.putInt("total", 5);
            intent.putExtras(b);

            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public void onClick(View view) {
        switch (((Button) view).getText().toString()) {
            case "Math":
                break;
            case "Physics":
                break;
            case "Biology":
                break;
            case "Chemistry":
                break;
            default:
                // shouldn't happen
        }
    }


}