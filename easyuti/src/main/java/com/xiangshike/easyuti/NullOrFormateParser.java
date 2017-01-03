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
        Object value = null;
        for (Field field :
                fields) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(com.xiangshike.easyuti.NullOrFormate.class)) {
                com.xiangshike.easyuti.NullOrFormate nullOrFormate = field.getAnnotation(NullOrFormate.class);
                String notNullStr = nullOrFormate.notNull();
                String timeFormate = nullOrFormate.timeFormate();
                boolean isTime = nullOrFormate.isTime();
                String type = field.getType().toString();

                try {
                    value = field.get(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if ( type.endsWith("String")) {
                    String tmpvalue = (String) value;
                    if (tmpvalue == null) {
                        try {
                            field.set(object, notNullStr);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    if (isTime) {


                        try {
                            String time = (String) field.get(object);
                            if (time != null && time.matches("[0-9]+")) {
                                DateFormat dateFormat = new SimpleDateFormat(timeFormate);
                                Date date = new Date(Integer.valueOf(time).longValue());
                                field.set(object, dateFormat.format(date));
                                Log.d("NullOrFormate", time + dateFormat.format(date));
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            Log.d("NullOrFormate", e.toString());

                        }

                    }

                }


            }
            value = null;
        }
    }
}