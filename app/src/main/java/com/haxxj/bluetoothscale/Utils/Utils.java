package com.haxxj.bluetoothscale.Utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/2/3.
 */

public class Utils {
    /**
     * 获得屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        //获取窗口管理服务
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        //屏幕参数对象
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }
    public static double round(Double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = null == v ? new BigDecimal("0.0") : new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    /**
     * 整合打印数据
     * @param byteList
     * @return
     */
    public static byte[] byteMerger(byte[][] byteList) {

        int length = 0;
        for (int i = 0; i < byteList.length; i++) {
            length += byteList[i].length;
        }
        byte[] result = new byte[length];

        int index = 0;
        for (int i = 0; i < byteList.length; i++) {
            byte[] nowByte = byteList[i];
            for (int k = 0; k < byteList[i].length; k++) {
                result[index] = nowByte[k];
                index++;
            }
        }
        for (int i = 0; i < index; i++) {
            // CommonUtils.LogWuwei("", "result[" + i + "] is " + result[i]);
        }
        return result;
    }

}
