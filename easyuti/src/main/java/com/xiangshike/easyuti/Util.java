package com.xiangshike.easyuti;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.widget.TextView;

/**
 * Created by liyulong on 2017/1/2.
 */

public class Util {
    public static boolean isNilOrNull(Object object) {

        if (object == null) {
            return true;
        }

        return false;
    }

    public static String text(TextView textView) {
        if (isNilOrNull(textView)) {
            return "";
        }
        return textView.getText().toString().trim();
    }

    /**
     * 获取文本
     * @param textView
     * @return
     */
    public static boolean hasText(TextView textView) {
        if (text(textView).length() >= 1) {
            return true;
        }
        return false;
    }
    
    /**
     * 检测是否是模拟器
     * @param context
     * @return
     */
    public static boolean isEmulator(Context context) {
        try {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            String imei = tm.getDeviceId();
            if (imei != null && imei.equals("000000000000000")) {
                return true;
            }
            return (Build.MODEL.equals("sdk")) || (Build.MODEL.equals("google_sdk"));
        } catch (Exception ioe) {

        }
        return false;
    }

}
