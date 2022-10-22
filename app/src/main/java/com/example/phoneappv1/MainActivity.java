package com.example.phoneappv1;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.phoneappv1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int qNum = 1, total = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Question q = new Question(
                "What is 1 + 1?",
                new String[]{"0", "1", "2", "3"},
                2,
                1
        );
        ft.replace(R.id.fragmentContainerView, MCQuestionFragment.newInstance(q, qNum));
        ft.commit();

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