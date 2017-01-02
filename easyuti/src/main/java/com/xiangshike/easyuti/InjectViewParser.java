package com.xiangshike.easyuti;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by liyulong on 2017/1/2.
 */

public class InjectViewParser {
    public static void inject(Object object) {
        try {
            parse(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parse(Object object) throws Exception {
        if (object == null) {
            throw new Exception("你必须设置一个Object");
        }
        final Class<?> clazz = object.getClass();
        View view = null;
        Field[] fields = clazz.getFields();
        for (Field field : fields
                ) {
            if (field.isAnnotationPresent(InjectView.class)) {
                InjectView injectView = field.getAnnotation(InjectView.class);
                int id = injectView.id();
                if (id < 0) {
                    throw new Exception("id must not be null");
                } else {
                    field.setAccessible(true);
                    if (object instanceof View) {
                        view = (View) ((View) object).findViewById(id);
                    }
                    if (object instanceof Activity) {
                        view =  ((Activity) object).findViewById(id);
                    }
                    if (view != null) {
                        field.set(object, view);
                    }
                }
            }
        }
    }
}
