package com.example.phoneappv1;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.phoneappv1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Science(View v){
        setContentView(R.layout.science_main);
    }

    public void Biology(View v){
        Button b = (Button)v;
        String text = b.getText().toString();
        Class c = new Class(text);
        setContentView(R.layout.biology_main);
    }

    public void exit(){
        setContentView(R.layout.activity_main);
    }
}