package com.example.asiantech.demoanimationdrawable.dialog;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.asiantech.demoanimationdrawable.R;
import com.example.asiantech.demoanimationdrawable.util.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 14/02/2017.
 */
public class CustomDialog extends Dialog implements View.OnClickListener {
    private Button mBtnOk;
    private onClickOk mOnclick;
    private ImageView mImgCub;
    private ImageView mImgHeader;
    private ImageView mImgNormal;
    private ImageView mImgNormal1;
    private ImageView mImgNormal2;
    private ImageView mImgNormal3;
    private ImageView mImgNormal4;
    private ImageView mImgNormal5;
    private ImageView mImgBalloon;
    private List<View> listViews = new ArrayList<>();

    public CustomDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.getWindow().getAttributes().windowAnimations = R.style.Animations_SmileWindow;
        this.setContentView(R.layout.custom_dialog);
        this.mBtnOk = (Button) this.findViewById(R.id.btnOk);
        this.mBtnOk.setOnClickListener(this);
        this.mImgCub = (ImageView) this.findViewById(R.id.imgCub);
        this.mImgHeader = (ImageView) this.findViewById(R.id.imgHeader);
        this.mImgNormal = (ImageView) this.findViewById(R.id.imgDiamondNormal);
        this.listViews.add(mImgNormal);
        this.mImgNormal1 = (ImageView) this.findViewById(R.id.imgDiamondNormal1);
        this.listViews.add(mImgNormal1);
        this.mImgNormal2 = (ImageView) this.findViewById(R.id.imgDiamondNormal2);
        this.listViews.add(mImgNormal2);
        this.mImgNormal3 = (ImageView) this.findViewById(R.id.imgDiamondNormal3);
        this.listViews.add(mImgNormal3);
        this.mImgNormal4 = (ImageView) this.findViewById(R.id.imgDiamondNormal4);
        this.listViews.add(mImgNormal4);
        this.mImgNormal5 = (ImageView) this.findViewById(R.id.imgDiamondNormal5);
        this.listViews.add(mImgNormal5);
        this.mImgBalloon = (ImageView) this.findViewById(R.id.imgBalloon);

        this.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.StartTranslateZoom(mImgCub);
        this.StartTranslateZoom(mImgHeader);
        this.moveListViewStart(listViews);
        this.moveBalloon(mImgBalloon);
    }

    @Override
    public void onClick(View v) {
        dismiss();
        if (mOnclick != null) {
            mOnclick.onClicks(v);
        }
    }

    public void setOnClick(onClickOk onClick) {
        this.mOnclick = onClick;
    }

    public interface onClickOk {
        void onClicks(View v);
    }

    private void moveListViewStart(List<View> list) {
        int width = ScreenUtils.getWidthScreen(getContext());
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setVisibility(View.VISIBLE);
            if (i % 2 == 0) {
                TranslateAnimation anim = new TranslateAnimation(0, width / 5, 0, (i * 100) - (width / 4) - 100);
                anim.setDuration(600);
                anim.setFillAfter(true);
                list.get(i).startAnimation(anim);

            } else {
                TranslateAnimation anim = new TranslateAnimation(0, -width / 5, 0, -(i * 100) + (width / 4) + 50);
                anim.setDuration(600);
                anim.setFillAfter(true);
                list.get(i).startAnimation(anim);
            }
            StartTranslateZoom(list.get(i));
        }
    }

    private void moveBalloon(View view) {
        view.setVisibility(View.VISIBLE);
        Animation animSlide = AnimationUtils.loadAnimation(getContext(), R.anim.slide_translate_view);
        view.startAnimation(animSlide);
    }

    private void StartTranslateZoom(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(view, "scaleX", 0f, 0.5f, 0.8f, 1.f, 1.5f, 1f),
                ObjectAnimator.ofFloat(view, "scaleY", 0f, 0.5f, 0.8f, 1.f, 1.5f, 1f)
        );
        animatorSet.setDuration(600L);
        animatorSet.start();
    }
}
