package com.example.asiantech.demoanimationdrawable.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Copyright © AsianTech Co., Ltd
 * Created by TaiND on 8/25/16.
 */
public class ScreenUtils {

    private ScreenUtils() {
    }


    /**
     * Convert value dp to pixel
     *
     * @param context context
     * @param dp      value need to converted
     * @return
     */
    public static float dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }

    public static float px2dp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return px / scale - 0.5f;
    }

    /**
     * This method is used to get width of screen
     *
     * @param context is current context
     * @return return width of screen in pixel
     */
    public static int getWidthScreen(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dimens = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dimens);
        return dimens.widthPixels;
    }

    /**
     * This method is used to get height of screen
     *
     * @param context is current context
     * @return return height of screen in pixel
     */
    public static int getHeightScreen(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dimens = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dimens);
        return dimens.heightPixels;
    }

}
