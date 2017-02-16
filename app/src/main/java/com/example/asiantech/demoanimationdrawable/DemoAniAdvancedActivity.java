package com.example.asiantech.demoanimationdrawable;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.asiantech.demoanimationdrawable.dialog.CustomDialogFragment;
import com.example.asiantech.demoanimationdrawable.views.ViewRotation;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 14/02/2017.
 */
public class DemoAniAdvancedActivity extends AppCompatActivity
        implements CustomDialogFragment.onClickDismiss {
    private ViewRotation mViewRotation;
    private CustomDialogFragment mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani_advanced);
        Button btnStart = (Button) findViewById(R.id.btnStart);
        mViewRotation = (ViewRotation) findViewById(R.id.viewRotation);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBackground();
                initDialog();
            }
        });
    }

    private void initDialog() {
        mDialog = new CustomDialogFragment();
        FragmentManager fm = getFragmentManager();
        mDialog.show(fm, "CustomFragment");
        mDialog.setOnClicks(this);
    }

    private void startBackground() {
        mViewRotation.setVisibility(View.VISIBLE);
        ObjectAnimator cardScaleX = ObjectAnimator.ofFloat(mViewRotation, "scaleX", 0.1f, 1f);
        ObjectAnimator cardScaleY = ObjectAnimator.ofFloat(mViewRotation, "scaleY", 0.1f, 1f);
        cardScaleX.setDuration(500);
        cardScaleY.setDuration(500);
    }

    @Override
    public void onClicks(View view) {
        mDialog.dismiss();
        mViewRotation.setVisibility(View.GONE);
    }
}
