package com.xiangshike.easyuti;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liyulong on 2017/1/3.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.LOCAL_VARIABLE, ElementType.FIELD, ElementType.METHOD})
public @interface NullOrFormate {

    /**
     * 时间戳字符串准换为对应的时间格式
     * @return
     */
    String timeFormate() default "yyy-MM-dd HH:mm:ss";


    String notNull() default "";

    /**
     * 只有是isTime的时候才会转化时间
     *
     * @return
     */
    boolean isTime() default false;


}
