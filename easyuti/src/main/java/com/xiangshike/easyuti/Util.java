package com.xiangshike.easyuti;

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

}
