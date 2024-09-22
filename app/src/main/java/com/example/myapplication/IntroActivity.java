package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.myapplication.Activity.MainActivity;
import com.example.myapplication.databinding.ActivityIntroBinding;
import com.example.myapplication.databinding.ActivityMainBinding;

public class IntroActivity extends AppCompatActivity {
    // Binding
    ActivityIntroBinding activityIntroBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityIntroBinding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(activityIntroBinding.getRoot());

        activityIntroBinding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}