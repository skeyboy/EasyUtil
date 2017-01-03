package com.xiangshike.easyuti;

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
            if (field.isAnnotationPresent(NullOrFormate.class)) {
                NullOrFormate nullOrFormate = field.getAnnotation(NullOrFormate.class);
                String notNullStr = nullOrFormate.notNull();
                String timeFormate = nullOrFormate.timeFormate();
                boolean isTime = nullOrFormate.isTime();

                if (timeFormate != null) {
                    if (isTime && timeFormate.length() > 0 && timeFormate.matches("[0-9]+")) {

                        try {
                            String time = (String) field.get(object);
                            DateFormat dateFormat = new SimpleDateFormat(timeFormate);
                            Date date = new Date(time);
                            field.set(object, dateFormat.format(date));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }

                if (notNullStr != null) {
                    if (notNullStr.length() > 0) {
                        try {
                            String value = (String) field.get(object);
                            if (value == null) {
                                field.set(object, "");
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }


            }
        }
    }
}
