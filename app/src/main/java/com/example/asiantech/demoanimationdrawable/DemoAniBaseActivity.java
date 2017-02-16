package com.example.asiantech.demoanimationdrawable;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.asiantech.demoanimationdrawable.dialog.CustomDialog;
import com.example.asiantech.demoanimationdrawable.views.ViewRotation;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 14/02/2017.
 */
public class DemoAniBaseActivity extends AppCompatActivity implements CustomDialog.onClickOk {
    private ImageView mImgGlass;
    private CustomDialog mCustomDialog;
    private ViewRotation mViewRotation;
    private AnimatorSet mScaleBackGroundRotation = new AnimatorSet();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani_base);
        Button btnStart = (Button) findViewById(R.id.btnStart);
        mViewRotation = (ViewRotation) findViewById(R.id.viewRotation);
        mImgGlass = (ImageView) findViewById(R.id.imgGlass);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBackground();
                startDialog();
                startAnimation();
            }
        });
    }

    private void startBackground() {
        mViewRotation.setVisibility(View.VISIBLE);
        ObjectAnimator cardScaleX = ObjectAnimator.ofFloat(mViewRotation, "scaleX", 0.1f, 1f);
        ObjectAnimator cardScaleY = ObjectAnimator.ofFloat(mViewRotation, "scaleY", 0.1f, 1f);
        cardScaleX.setDuration(500);
        cardScaleY.setDuration(500);
    }

    private void startAnimation() {
        mImgGlass.setBackgroundResource(R.drawable.glass);
        AnimationDrawable animationDrawable = (AnimationDrawable) mImgGlass.getBackground();
        animationDrawable.setVisible(true, true);
        animationDrawable.setOneShot(true);
        animationDrawable.start();
    }

    private void startDialog() {
        mCustomDialog = new CustomDialog(this);
        mCustomDialog.setOnClick(this);
        Window window = mCustomDialog.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.flags &= ~WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.y = 0;
        window.setAttributes(layoutParams);
        mCustomDialog.setCanceledOnTouchOutside(false);
        mCustomDialog.show();
    }

    @Override
    public void onClicks(View v) {
        mCustomDialog.dismiss();
        mViewRotation.setVisibility(View.GONE);
    }
}
