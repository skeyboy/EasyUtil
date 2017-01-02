package com.xiangshike.easyuti;

import android.app.Activity;
import android.view.View;

/**
 * Created by liyulong on 2017/1/2.
 */

public class ViewUtis {
    /**
     * 仅用于获取对应组件使用
     *
     * @param activity
     * @param resId
     * @param <E>
     * @return
     */
    @Deprecated
    public static <E extends View> E findViewById(Activity activity, int resId) {
        return (E) activity.findViewById(resId);
    }

    @Deprecated
    public static <E extends View> E findViewById(View view, int resId) {

        return (E) view.findViewById(resId);
    }

    public static <E extends View> E find(Activity activity, int id) {
        return (E) activity.findViewById(id);
    }

    public static <E extends View>E find(View rootView, int id) {
        return (E) rootView.findViewById(id);
    }

}
