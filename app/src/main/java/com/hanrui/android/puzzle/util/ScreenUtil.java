package com.hanrui.android.puzzle.util;

import android.content.ContentValues;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017/5/16 0016.
 */

public class ScreenUtil {

    //获取屏幕相关参数，宽高
    public static DisplayMetrics getScreenSize(Context context){
        DisplayMetrics metrics=new DisplayMetrics();//获取DisplayMetrics实例
        WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display=wm.getDefaultDisplay();
        display.getMetrics(metrics);//将当前窗口的一些信息放入DisplayMetrics当中
        return metrics;
    }

    //获取屏幕density
    public static float getDeviceDensity(Context context){
        DisplayMetrics metrics=new DisplayMetrics();
        WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        return metrics.density;
    }
}
