package com.example.asiantech.demoanimationdrawable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAniBase = (Button) findViewById(R.id.btnDemoAnimationBase);
        btnAniBase.setOnClickListener(this);
        Button btnAniAdvanced = (Button) findViewById(R.id.btnDemoAnimationAdvanced);
        btnAniAdvanced.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDemoAnimationBase:
                initActivity(DemoAniBaseActivity.class);
                break;
            case R.id.btnDemoAnimationAdvanced:
                initActivity(DemoAniAdvancedActivity.class);
                break;
            default:
                break;
        }
    }

    private void initActivity(Class className) {
        Intent intent = new Intent(MainActivity.this, className);
        this.startActivity(intent);
    }
}
