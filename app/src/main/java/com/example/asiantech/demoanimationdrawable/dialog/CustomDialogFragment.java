package com.example.asiantech.demoanimationdrawable.dialog;


import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.asiantech.demoanimationdrawable.R;
import com.example.asiantech.demoanimationdrawable.views.ViewRotation;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 15/02/2017.
 */
public class CustomDialogFragment extends DialogFragment {

    private onClickDismiss mOnclick;
    private ViewRotation mViewRotation;
    private ImageView mImgGlass;
    private ImageView mImgCub;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.getWindow().getAttributes().windowAnimations = R.style.Animations_SmileWindow;
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        dialog.setContentView(R.layout.custom_dialog_fragment);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mViewRotation = (ViewRotation) dialog.findViewById(R.id.viewRotation);
        mImgGlass = (ImageView) dialog.findViewById(R.id.imgGlass);
        mImgCub = (ImageView) dialog.findViewById(R.id.imgCub);
        setCancelable(false);
        startBackground();
        startAnimation();
        Button btnOk = (Button) dialog.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                if (mOnclick != null) {
                    mOnclick.onClicks(view);
                }
            }
        });
        return dialog;
    }

    private void startAnimation() {
        mImgGlass.setBackgroundResource(R.drawable.glass);
        AnimationDrawable animationDrawable = (AnimationDrawable) mImgGlass.getBackground();
        animationDrawable.setVisible(true, true);
        animationDrawable.setOneShot(true);
        animationDrawable.start();
    }

    private void startBackground() {
        mViewRotation.setVisibility(View.VISIBLE);
        ObjectAnimator cardScaleX = ObjectAnimator.ofFloat(mViewRotation, "scaleX", 0.1f, 1f);
        ObjectAnimator cardScaleY = ObjectAnimator.ofFloat(mViewRotation, "scaleY", 0.1f, 1f);
        cardScaleX.setDuration(500);
        cardScaleY.setDuration(500);
    }

    public void setOnClicks(onClickDismiss onclick) {
        this.mOnclick = onclick;
    }

    public interface onClickDismiss {
        void onClicks(View view);
    }

}
