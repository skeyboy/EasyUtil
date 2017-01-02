package com.xiangshike.easyuti;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by liyulong on 2017/1/2.
 */

public class ToastUtils {
    /**
     *
     * @param context
     * @param str
     */
    public static void showToast(Context context, String str) {

        Toast.makeText(context, str, Toast.LENGTH_LONG).show();
    }
}
