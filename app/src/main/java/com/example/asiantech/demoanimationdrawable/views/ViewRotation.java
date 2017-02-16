package com.example.asiantech.demoanimationdrawable.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import com.example.asiantech.demoanimationdrawable.R;


/**
 * Copyright © 2015 AsianTech inc.
 * Created by Binc on 29/08/2016.
 */
public class ViewRotation extends View {
    private int mRotation;
    private Bitmap mBitmap;
    private float mAlpha = 1f;
    private int mStatus = -1;

    public ViewRotation(Context context) {
        super(context);
        init();
    }

    public ViewRotation(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.illumina);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                // set alpha background rotation
                if (mAlpha == 1) {
                    mStatus = -1;
                } else if (mAlpha <= 0.1f) {
                    mStatus = 1;
                }
                mAlpha = mAlpha + 0.1f * mStatus;
                setAlpha(mAlpha);

                invalidate();
                handler.postDelayed(this, 50);
            }
        }, 50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Matrix matrix = this.getMatrix();
        mRotation -= 1;
        float px = getWidth() / 2;
        float py = getHeight() / 2;
        matrix.postTranslate(-mBitmap.getWidth() / 2, -mBitmap.getHeight() / 2);
        matrix.postRotate(mRotation);
        matrix.postTranslate(px, py);
        canvas.drawBitmap(mBitmap, matrix, null);
    }
}
