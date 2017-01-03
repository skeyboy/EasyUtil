package com.xiangshike.easyuti;

import android.util.Log;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liyulong on 2017/1/3.
 */

public class NullOrFormateParser {
    public static void check(Object object) {
        if (object == null) {
            return;
        }

        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getFields();
        for (Field field :
                fields) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(NullOrFormate.class)) {
                NullOrFormate nullOrFormate = field.getAnnotation(NullOrFormate.class);
                String notNullStr = nullOrFormate.notNull();
                String timeFormate = nullOrFormate.timeFormate();
                boolean isTime = nullOrFormate.isTime();

                if ("".equals(notNullStr) || null == notNullStr) {
                    try {
                        field.set(object, "");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                if (isTime) {


                    try {
                        String time = (String) field.get(object);
                        if (time != null && time.matches("[0-9]+")) {
                            DateFormat dateFormat = new SimpleDateFormat(timeFormate);
                            Date date = new Date(time);
                            field.set(object, dateFormat.format(date));
                            Log.d("NullOrFormate", time+dateFormat.format(date));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        Log.d("NullOrFormate", e.toString());

                    }

                }


            }
        }
    }
}
